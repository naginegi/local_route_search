/**
 * 
 */


////////////////////////////////////////////////////////////
function get_total_local_data() {
	//拿全部資料
	const totalData = JSON.parse(document.getElementById("totalData").value)
	//	console.log(totalData)


	//找出都道府
	let uniqueSet = new Set();
	totalData.forEach((value) => uniqueSet.add(value.prefName));

	let prefData = Array.from(uniqueSet);
	//	console.log(prefData);

	//把都道府放到select
	const prefSelect = document.getElementById("pref_select")

	prefData.forEach((pref) => {
		const opt = document.createElement("option")
		opt.value = pref;
		opt.text = pref;
		prefSelect.appendChild(opt);
	});


}


function select_pref() {
	//下拉選單選都道府時
	const prefSelect = document.getElementById("pref_select").value
	//	console.log(prefSelect)
	//取全部資料
	const totalData = JSON.parse(document.getElementById("totalData").value)
	//	console.log(totalData)

	//把該都道府的市町村放進去一個陣列
	//再創建opt
	const localSelect = document.getElementById("local_select")
	let arr = []
	totalData.forEach((total) => {
		if (total.prefName == prefSelect) {
			if (!arr.includes(total.localName)) {
				arr.push(total.localName)
			}
		}
	});
	localSelect.innerHTML = ""
	arr.forEach((local) => {
		const opt = document.createElement("option")
		opt.value = local;
		opt.text = local;
		localSelect.appendChild(opt);
	});
	select_local()
}

function select_local() {
	//選好督道府或市町村
	const prefSelect = document.getElementById("pref_select").value
	const localSelect = document.getElementById("local_select").value
	const buildingAddress = document.getElementById("buildingAddress")
	const lineSelect = document.getElementById("LineName")

	buildingAddress.value = prefSelect + localSelect
	//	console.log(prefSelect)
	//	console.log(localSelect)

	//取全部資料路線車站
	const totalStationData = JSON.parse(document.getElementById("total_station_data").value)
	//	console.log(totalStationData)

	//用都道府的資料找路線
	const arr = []
	totalStationData.forEach((total) => {
		if (total.prefName == prefSelect) {
			if (!arr.includes(total.lineName)) {
				arr.push(total.lineName)
			}
		}
	});
	lineSelect.innerHTML = ""
	arr.forEach((line) => {
		const opt = document.createElement("option")
		opt.value = line;
		opt.text = line;
		lineSelect.appendChild(opt);
	});
	select_line()
}


function select_line() {
	const lineSelect = document.getElementById("LineName").value
	const stationSelect = document.getElementById("StationName")

	//取全部資料路線車站
	const totalStationData = JSON.parse(document.getElementById("total_station_data").value)
	//	console.log(totalStationData)
	//用路線的資料找車站
	const arr = []
	totalStationData.forEach((total) => {
		if (total.lineName == lineSelect) {
			if (!arr.includes(total.stationName)) {
				arr.push(total.stationName)
			}
		}
	});
	stationSelect.innerHTML = ""
	arr.forEach((station) => {
		const opt = document.createElement("option")
		opt.value = station;
		opt.text = station;
		stationSelect.appendChild(opt);
	});
	//select_station()

}

//let i = 0;
function select_station() {
	const lineSelect = document.getElementById("LineName").value
	const stationSelect = document.getElementById("StationName").value
	const nearText = document.getElementById("nearText")
	const WarkingTime = document.getElementById("WarkingTime").value


	const div = document.createElement("div")
	const lineSpan = document.createElement("span")
	const stationSpan = document.createElement("span")
	const warkSpan = document.createElement("span")
	const editBtn = document.createElement("button")
	const deleBtn = document.createElement("button")

	div.className = "nearInputDiv"

	lineSpan.className = "near LineName"
	stationSpan.className = "near StationName"
	warkSpan.className = "near WarkingTime"

	editBtn.className = "nearInputBtn"
	deleBtn.className = "nearInputBtn"
	//	deleBtn.id = `dele_${i}`

	//	span.textContent = lineSelect + " " + stationSelect + " 徒步距離 " + WarkingTime + " 分  "
	lineSpan.innerHTML = lineSelect
	stationSpan.innerHTML = stationSelect
	warkSpan.innerHTML = WarkingTime

	//	editBtn.innerHTML = "<i class='fa-solid fa-pen'></i>"	
	//	deleBtn.innerHTML = `<i class='fa-solid fa-trash' onclick=delenear(${i})></i>`

	const btnDiv = document.createElement("div")
	btnDiv.className = "near Function"
	btnDiv.style = "display:flex;justify-content: space-around;"
	//	btnDiv.appendChild(editBtn)
	btnDiv.appendChild(deleBtn)

	div.appendChild(lineSpan)
	div.appendChild(stationSpan)
	div.appendChild(warkSpan)
	//	div.appendChild(btnDiv)

	nearText.appendChild(div)
	
	
	
	//加session
	let NearList = []
	if(sessionStorage.getItem("NearList")){
		NearList=JSON.parse(sessionStorage.getItem("NearList"))
	}
	const nearData = {
		nearLine:lineSelect,
		nearStation:stationSelect,
		warkingTime:WarkingTime		
	}
	NearList.push(nearData)
	sessionStorage.setItem("NearList",JSON.stringify(NearList))
}

function delenear() {
	const nearText = document.getElementById("nearText")
	nearText.removeChild(nearText.children[nearText.children.length - 1])
	
	//session
	const nearList = JSON.parse(sessionStorage.getItem("NearList"))
    nearList.splice(nearList.length - 1, 1);
    sessionStorage.setItem("NearList",JSON.stringify(nearList))
}

function buildingTypeSelect() {
	const buildingType = document.getElementById("buildingType").value
	const roomNum = document.getElementById("roomNum")
	if (buildingType == "戶建") {
		roomNum.value = "戶建"
		roomNum.readOnly = true;
	} else {
		roomNum.value = ""
		roomNum.readOnly = false;
	}

}
/*
function save_data() {
	// bu data 
	// 建物名稱 種類 構造 都道府 市町村 所在地 床面積 築年數 備考
	const buildingName = document.getElementsById("buildingName").value
	const buildingType = document.getElementsById("buildingType").value
	const pref_select = document.getElementsById("pref_select").value
	const local_select = document.getElementsById("local_select").value
	const buildingAddress = document.getElementsById("buildingAddress").value
	const buildingArea = document.getElementsById("buildingArea").value
	const yearOfBuild = document.getElementsById("yearOfBuild").value
	const buildingNotes = document.getElementsById("buildingNotes").value
	// cmEq data
	// 電梯 自動鎖 信箱 郵箱 駐車廠 備考
	const elevator = document.getElementsById("elevator").value
	const autoLock = document.getElementsById("autoLock").value
	const mailBox = document.getElementsById("mailBox").value
	const deliveryBox = document.getElementsById("deliveryBox").value
	const parking = document.getElementsById("parking").value
	const cmeqNotes = document.getElementsById("cmeqNotes").value
	// eq data
	// 
	const roomNum = document.getElementsById("roomNum").value
	const roomLayout = document.getElementsById("roomLayout").value
	const electric = document.getElementsById("electric").value
	const gas = document.getElementsById("gas").value
	const stove = document.getElementsById("stove").value
	const waterWorks = document.getElementsById("waterWorks").value
	const sewage = document.getElementsById("sewage").value
	const airConditioner = document.getElementsById("airConditioner").value
	const kitchen = document.getElementsById("kitchen").value
	const toilet = document.getElementsById("toilet").value
	const bathroom = document.getElementsById("bathroom").value
	const basin = document.getElementsById("basin").value
	const roofBalcony = document.getElementsById("roofBalcony").value
	const keyNum = document.getElementsById("keyNum").value
	const furniture = document.getElementsById("furniture").value
	const washingMachine = document.getElementsById("washingMachine").value
	const light = document.getElementsById("light").value
	const internet = document.getElementsById("internet").value
	const trunkRoom = document.getElementsById("trunkRoom").value
	const tv = document.getElementsById("tv").value
	const catv = document.getElementsById("catv").value
	const yard = document.getElementsById("yard").value
	const eqNotes = document.getElementsById("eqNotes").value
	// fee data
	//
	const rent = document.getElementsById("rent").value
	const deposit = document.getElementsById("deposit").value
	const reward = document.getElementsById("reward").value
	const commonExpenses = document.getElementsById("commonExpenses").value
	const maxAmount = document.getElementsById("maxAmount").value
	const renewal = document.getElementsById("renewal").value
	const otherExpenses = document.getElementsById("otherExpenses").value
	const payMethods = document.getElementsById("payMethods").value
	const riderClause = document.getElementsById("riderClause").value
	// lessor data
	// 
	const lessorName = document.getElementsById("lessorName").value
	const lessorPhone = document.getElementsById("lessorPhone").value
	const lessorAddress = document.getElementsById("lessorAddress").value
	const lessorNotes = document.getElementsById("lessorNotes").value

	// manager data
	// 
	const managerName = document.getElementsById("managerName").value
	const managerPhone = document.getElementsById("managerPhone").value
	const managerAddress = document.getElementsById("managerAddress").value
	const managerNotes = document.getElementsById("managerNotes").value

	// borrower data
	// 
	const lessorName = document.getElementsById("lessorName").value
	const lessorPhone = document.getElementsById("lessorPhone").value
	const lessorAddress = document.getElementsById("lessorAddress").value
	const lessorNotes = document.getElementsById("lessorNotes").value

	// near data
	// 
	const lessorName = document.getElementsById("lessorName").value
	const lessorPhone = document.getElementsById("lessorPhone").value
	const lessorAddress = document.getElementsById("lessorAddress").value
	const lessorNotes = document.getElementsById("lessorNotes").value

}
*/

function objRoomCreateSave() {

	//roomData
	const roomNum = document.getElementById("roomNum").value
	const roomArea = document.getElementById("roomArea").value
	const roomLayout = document.getElementById("roomLayout").value

	const roomData = {
		buId: 0,
		roomNum: roomNum,
		roomArea: roomArea,
		roomLayout: roomLayout
	}

	//eqData
	const electric = document.getElementById("electric").value
	const gas = document.getElementById("gas").value
	const stove = document.getElementById("stove").value
	const waterWorks = document.getElementById("waterWorks").value
	const sewage = document.getElementById("sewage").value
	const airConditioner = document.getElementById("airConditioner").value
	const kitchen = document.getElementById("kitchen").value
	const toiBath = document.getElementById("toiBath").value
	const roofBalcony = document.getElementById("roofBalcony").value
	const washingMachine = document.getElementById("washingMachine").value
	const light = document.getElementById("light").value
	const internet = document.getElementById("internet").value
	const trunkRoom = document.getElementById("trunkRoom").value
	const tv = document.getElementById("tv").value
	const catv = document.getElementById("catv").value
	const yard = document.getElementById("yard").value
	const waterHeater = document.getElementById("waterHeater").value
	const furniture = document.getElementById("furniture").value

	const equipmentData = {
		buId: 0,
		roomNum:roomNum,
		electric:electric,
		gas:gas,
		stove:stove,
		waterWorks:waterWorks,
		sewage:sewage,
		airConditioner:airConditioner,
		kitchen:kitchen,
		toiBath:toiBath,
		roofBalcony:roofBalcony,
		washingMachine:washingMachine,
		light:light,
		internet:internet,
		trunkRoom:trunkRoom,
		tv:tv,
		catv:catv,
		yard:yard,
		waterHeater:waterHeater,
		furniture:furniture
	}

	//feeData
	const rent = document.getElementById("rent").value
	const deposit = document.getElementById("deposit").value
	const reward = document.getElementById("reward").value
	const commonExpenses = document.getElementById("commonExpenses").value
	const renewal = document.getElementById("renewal").value
	const otherExpenses = document.getElementById("otherExpenses").value
	const feeNotes = document.getElementById("feeNotes").value


	const feeData={
		buId:0,
		roomNum:roomNum,
		rent:rent,
		deposit:deposit,
		reward:reward,
		commonExpenses:commonExpenses,
		renewal:renewal,
		otherExpenses:otherExpenses,
		feeNotes:feeNotes
	}


	//roomData
	let roomDataVo = []
	if(sessionStorage.getItem("roomDataVo")){
		roomDataVo = JSON.parse(sessionStorage.getItem("roomDataVo"))
	}
	const Data = {
		roomData:roomData,
		equipmentData:equipmentData,
		feeData:feeData
	}
	console.log(Data)
	roomDataVo.push(Data)
	console.log(roomDataVo)
	
	sessionStorage.setItem("roomDataVo",JSON.stringify(roomDataVo))
}

function get_roomDataVo(){
	const roomDataVo = JSON.parse(sessionStorage.getItem("roomDataVo"))
	const roomListDiv = document.getElementById("roomListDiv")
	roomListDiv.innerHTML = ""
	roomDataVo.forEach((room,index) => {
		const roomList = document.createElement("div")
		const Num = document.createElement("span")
		roomList.className = "roomList"
		Num.innerHTML = " 号室 ：" + room.roomData.roomNum
		roomList.innerHTML = `<button class="fa-solid fa-trash" style="font-size: 16pt;border: 0px solid;background-color: transparent;color: white;cursor: pointer;" onclick=deleRoom(${index})></button>`
		roomList.appendChild(Num)
		roomListDiv.appendChild(roomList)
	});
}


function test(index){
	console.log(index)
	const roomData = JSON.parse(sessionStorage.getItem("roomDataVo"))
	console.log(roomData[index])
}

function deleRoom(index){
	const roomData = JSON.parse(sessionStorage.getItem("roomDataVo"))
	roomData.splice(index,1)
	sessionStorage.setItem("roomDataVo",JSON.stringify(roomData))
	get_roomDataVo()
}

function objBuCreateSave(){
	const buildingData={
		buName:document.getElementById("buildingName").value,
		buType:document.getElementById("buildingType").value,
		buYear:document.getElementById("yearOfBuild").value,
		buMaterials:document.getElementById("buildingMaterials").value,	
		buPref:document.getElementById("pref_select").value,
		buLocal:document.getElementById("local_select").value,
		buAddress:document.getElementById("buildingAddress").value,
		buNotes:document.getElementById("buildingNotes").value,
	}
	const commonEquipmentData={
		elevator:document.getElementById("elevator").value,
		autoLock:document.getElementById("autoLock").value,
		mailBox:document.getElementById("mailBox").value,
		deliveryBox:document.getElementById("deliveryBox").value,
		parking:document.getElementById("parking").value,
		cmeqNotes:document.getElementById("cmeqNotes").value
	}
	const nearList = JSON.parse(sessionStorage.getItem("NearList"))
	const roomDataVo = JSON.parse(sessionStorage.getItem("roomDataVo"))
	
	const ObjectReq={
		buildingData:buildingData,
		commonEquipmentData:commonEquipmentData,
		nearList:nearList,
		roomDataVo:roomDataVo
	}
	
	sessionStorage.setItem("ObjectReq",JSON.stringify(ObjectReq))
	let buData = document.getElementById("buData")
	buData.value = JSON.stringify(ObjectReq)
	console.log(ObjectReq)
	console.log(buData.value)
//	sessionStorage.clear();
//	buData.value = "test"
}



function createRoom_setSession(){
	const buildingData={
		buName:document.getElementById("buildingName").value,
		buType:document.getElementById("buildingType").value,
		buYear:document.getElementById("yearOfBuild").value,
		buMaterials:document.getElementById("buildingMaterials").value,	
		buPref:document.getElementById("pref_select").value,
		buLocal:document.getElementById("local_select").value,
		buAddress:document.getElementById("buildingAddress").value,
		buNotes:document.getElementById("buildingNotes").value,
	}
	const commonEquipmentData={
		elevator:document.getElementById("elevator").value,
		autoLock:document.getElementById("autoLock").value,
		mailBox:document.getElementById("mailBox").value,
		deliveryBox:document.getElementById("deliveryBox").value,
		parking:document.getElementById("parking").value,
		cmeqNotes:document.getElementById("cmeqNotes").value
	}
	const nearList = JSON.parse(sessionStorage.getItem("NearList"))
	const roomDataVo = JSON.parse(sessionStorage.getItem("roomDataVo"))
	
	const ObjectReq={
		buildingData:buildingData,
		commonEquipmentData:commonEquipmentData,
		nearList:nearList,
		roomDataVo:roomDataVo
	}
	
	sessionStorage.setItem("ObjectReq",JSON.stringify(ObjectReq))
	
	
}


function get_old_data(){
	if(!sessionStorage.getItem("ObjectReq")){
		return
	}
	const bu = JSON.parse(sessionStorage.getItem("ObjectReq")).buildingData
	const cmeq = JSON.parse(sessionStorage.getItem("ObjectReq")).commonEquipmentData
	console.log(bu)
	console.log(cmeq)
	
	//bu
	document.getElementById("buildingName").value = bu.buName;
	document.getElementById("buildingType").value = bu.buType;
	document.getElementById("yearOfBuild").value = bu.buYear;
	document.getElementById("buildingMaterials").value = bu.buMaterials;
	document.getElementById("pref_select").value = bu.buPref;
	select_pref()
	document.getElementById("local_select").value = bu.buLocal;
	document.getElementById("buildingAddress").value = bu.buAddress;
	document.getElementById("buildingNotes").value = bu.buNotes;
	
	
	//cmeq
	document.getElementById("elevator").value = cmeq.elevator;
	document.getElementById("autoLock").value = cmeq.autoLock;
	document.getElementById("mailBox").value = cmeq.mailBox;
	document.getElementById("deliveryBox").value = cmeq.deliveryBox;
	document.getElementById("parking").value = cmeq.parking
	document.getElementById("cmeqNotes").value = cmeq.cmeqNotes;
	
	
	
	//near
	get_old_near()

	
	
	//roomList
//	get_old_room()
	
	
}


function get_old_near(){
	const nearList = JSON.parse(sessionStorage.getItem("NearList"))
	if (!nearList || nearList.length <= 0) {
		return
	}
	const nearText = document.getElementById("nearText")
	nearList.forEach((near) => {
		
	const lineSelect = near.nearLine
	const stationSelect = near.nearStation
	const WarkingTime = near.warkingTime


	const div = document.createElement("div")
	const lineSpan = document.createElement("span")
	const stationSpan = document.createElement("span")
	const warkSpan = document.createElement("span")
	const editBtn = document.createElement("button")
	const deleBtn = document.createElement("button")

	div.className = "nearInputDiv"

	lineSpan.className = "near LineName"
	stationSpan.className = "near StationName"
	warkSpan.className = "near WarkingTime"

	editBtn.className = "nearInputBtn"
	deleBtn.className = "nearInputBtn"

	lineSpan.innerHTML = lineSelect
	stationSpan.innerHTML = stationSelect
	warkSpan.innerHTML = WarkingTime

	const btnDiv = document.createElement("div")
	btnDiv.className = "near Function"
	btnDiv.style = "display:flex;justify-content: space-around;"
	btnDiv.appendChild(deleBtn)

	div.appendChild(lineSpan)
	div.appendChild(stationSpan)
	div.appendChild(warkSpan)

	nearText.appendChild(div)
	});
	
}


function get_old_room(){
	const roomDataVo = JSON.parse(sessionStorage.getItem("roomDataVo"))
	if (!roomDataVo && roomDataVo.length > 0) {
		return
	}
	const roomListDiv = document.getElementById("roomListDiv")
	roomListDiv.innerHTML = ""
	roomDataVo.forEach((room,index) => {
		const roomList = document.createElement("div")
		const Num = document.createElement("span")
		roomList.className = "roomList"
		roomList.innerHTML = `<button onclick=test(${index})>view</button><button onclick=deleRoom(${index})>dele</button>`
		Num.innerHTML = room.roomData.roomNum
		roomList.appendChild(Num)
		roomListDiv.appendChild(roomList)
	});
}

function clear_session(){
	sessionStorage.clear()
}
