/**
 * 
 */

/*
session
頁面:session名稱
 
pref:prefName
local:localName
building:buildingData
Equipment:equipmentData
Fee:feeData
Near:nearData
 
*/

////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
//prdef的部分

function get_session_pref() {
	//紀錄都道府的選項
	//並在返回上頁時給值

	//取ID時要整個取進
	selectPref = document.getElementById('select_pref');
	const prefNameJson = sessionStorage.getItem('prefName');

	const prefName = JSON.parse(prefNameJson);
	//		return
	console.log(prefName)
	selectPref.value = prefName;

}

function session_pref() {
	//儲存物件所在都道府到session
	//pref:prefName
	//讓select的值是上次所選的值

	//取ID時要取value
	prefName = document.getElementById('select_pref').value;
	const prefNameJson = JSON.stringify(prefName);
	sessionStorage.setItem('prefName', prefNameJson);
	get_select_local_option()
}

function clear_session_pref() {
	//pref返回check時，清除session，設定為空，不要清
	//pref:prefName
	sessionStorage.setItem('prefName', "");
}
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
//local的部分 
function get_session_local() {
	get_select_local_option()
	//讓select的值是上次所選的值
	const localNameJson = sessionStorage.getItem('localName');

	const localName = JSON.parse(localNameJson);
	selectLocal.value = localName;
}

function get_select_local_option() {
	//從session找督到府，再找出該都道府的市町村
	const prefNameJson = sessionStorage.getItem('prefName');
	const arr = []
	const prefName = JSON.parse(prefNameJson);
	// 全部資料
	localData = JSON.parse(document.getElementById('localData').value);
	console.log(localData)

	localData.forEach(function(local) {
		if (local.prefName == prefName) {
			arr.push(local.localName)
		}
	});
	console.log(arr)
	//將找出的市町村印到option
	const selectLocal = document.getElementById('select_loacl');
	selectLocal.innerHTML = ""
	arr.forEach(function(local) {
		const opt = document.createElement("option");
		opt.value = local;
		opt.text = local;
		selectLocal.appendChild(opt);
	});


}




function session_local() {
	document.getElementById('form').addEventListener('submit', function(event) {
	prefName = document.getElementById('select_pref').value;
	localName = document.getElementById('select_loacl').value;
	if (prefName == '' || localName == '') {
		alert("オプションを空白にしないでください")
		event.preventDefault();
	}
});
	// local:localName
	localName = document.getElementById('select_loacl').value;
	const localNameJson = JSON.stringify(localName);
	sessionStorage.setItem('localName', localNameJson);
}

function claer_session_local() {
	sessionStorage.setItem('localName', "");
}


////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
//building的部分

function get_session_building() {

	//先取得pref資訊，供返回使用
	//取session 記得轉換 set進隱藏input.value
	const prefName = JSON.parse(sessionStorage.getItem('prefName'));
	document.getElementById('prefInput').value = prefName;
	console.log(prefInput.value)

	//取 session building:buildingData
	const localName = JSON.parse(sessionStorage.getItem('localName'));
	const buildingDataJson = sessionStorage.getItem("buildingData")
	if (buildingDataJson) {

		const buildingData = JSON.parse(buildingDataJson);
		console.log(buildingData)
		document.getElementById('buildingName').value = buildingData.buildingName;
		document.getElementById('buildingAddress').value = buildingData.buildingAddress;
		document.getElementById('buildingType').value = buildingData.buildingType;
		document.getElementById('buildingMaterials').value = buildingData.buildingMaterials;
		document.getElementById('buildingArea').value = buildingData.buildingArea;
		document.getElementById('roomNum').value = buildingData.roomNum;
		document.getElementById('roomLayout').value = buildingData.roomLayout;
		document.getElementById('yearOfBuild').value = buildingData.yearOfBuild;
	}
	document.getElementById('buildingPref').value = prefName;
	document.getElementById('buildingLocal').value = localName;
}


function session_building() {
	//儲存基本資料到session
	//從session抓物件所在都道府是市町村存入
	//building:buildingData
	const buildingData = {
		buildingName: document.getElementById('buildingName').value,
		buildingAddress: document.getElementById('buildingAddress').value,
		buildingType: document.getElementById('buildingType').value,
		buildingMaterials: document.getElementById('buildingMaterials').value,
		buildingArea: document.getElementById('buildingArea').value,
		buildingPref: document.getElementById('buildingPref').value,
		buildingLocal: document.getElementById('buildingLocal').value,
		roomNum: document.getElementById('roomNum').value,
		roomLayout: document.getElementById('roomLayout').value,
		yearOfBuild: document.getElementById('yearOfBuild').value,
	};

	//轉成JSON字串後存session
	sessionStorage.setItem('buildingData', JSON.stringify(buildingData));

	//存進隱藏的input 最後取出全部資療時才會用到
	//	document.getElementById('buildingInput').value = buildingDataJson;

	console.log(buildingDataJson);
}

function clear_session_building() {
	const buildingData = {
		buildingName: "",
		buildingAddress: "",
		buildingType: "",
		buildingMaterials: "",
		buildingArea: "",
		buildingPref: "",
		buildingLocal: "",
		roomNum: "",
		roomLayout: "",
		yearOfBuild: "",
	};
	const buildingDataJson = JSON.stringify(buildingData);
	sessionStorage.setItem('buildingData', buildingDataJson);
}

////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
//Equipment的部分

function get_session_equipment() {
	const equipmentData = JSON.parse(sessionStorage.getItem('equipmentData'));
	if (!sessionStorage.getItem('equipmentData')) {
		return
	}
	document.getElementById('electric').value = equipmentData.electric;
	document.getElementById('gas').value = equipmentData.gas;
	document.getElementById('stove').value = equipmentData.stove;
	document.getElementById('waterWorks').value = equipmentData.waterWorks;
	document.getElementById('sewage').value = equipmentData.sewage;
	document.getElementById('kitchen').value = equipmentData.kitchen;
	document.getElementById('toilet').value = equipmentData.toilet;
	document.getElementById('bathroom').value = equipmentData.bathroom;
	document.getElementById('basin').value = equipmentData.basin;
	document.getElementById('washingMachine').value = equipmentData.washingMachine;
	document.getElementById('airConditioner').value = equipmentData.airConditioner;
	document.getElementById('light').value = equipmentData.light;
	document.getElementById('internet').value = equipmentData.internet;
	document.getElementById('trunkRoom').value = equipmentData.trunkRoom;
	//
	document.getElementById('roofBalcony').value = equipmentData.roofBalcony;
	document.getElementById('keyNum').value = equipmentData.keyNum;
	document.getElementById('elevator').value = equipmentData.elevator;
	document.getElementById('autoLock').value = equipmentData.autoLock;
	document.getElementById('mailBox').value = equipmentData.mailBox;
	document.getElementById('deliveryBox').value = equipmentData.deliveryBox;
	document.getElementById('parking').value = equipmentData.parking;
	document.getElementById('pet').value = equipmentData.pet;
	document.getElementById('furniture').value = equipmentData.furniture;
	document.getElementById('TV').value = equipmentData.TV;
	document.getElementById('CATV').value = equipmentData.CATV;
	document.getElementById('yard').value = equipmentData.yard;
	document.getElementById('notes').value = equipmentData.notes;


}

function session_equipment() {
	//Equipment:equipmentData

	const equipmentData = {
		electric: document.getElementById('electric').value,
		gas: document.getElementById('gas').value,
		stove: document.getElementById('stove').value,
		waterWorks: document.getElementById('waterWorks').value,
		sewage: document.getElementById('sewage').value,
		kitchen: document.getElementById('kitchen').value,
		toilet: document.getElementById('toilet').value,
		bathroom: document.getElementById('bathroom').value,
		basin: document.getElementById('basin').value,
		washingMachine: document.getElementById('washingMachine').value,
		airConditioner: document.getElementById('airConditioner').value,
		light: document.getElementById('light').value,
		internet: document.getElementById('internet').value,
		trunkRoom: document.getElementById('trunkRoom').value,
		//
		roofBalcony: document.getElementById('roofBalcony').value,
		keyNum: document.getElementById('keyNum').value,
		elevator: document.getElementById('elevator').value,
		autoLock: document.getElementById('autoLock').value,
		mailBox: document.getElementById('mailBox').value,
		deliveryBox: document.getElementById('deliveryBox').value,
		parking: document.getElementById('parking').value,
		pet: document.getElementById('pet').value,
		furniture: document.getElementById('furniture').value,
		TV: document.getElementById('TV').value,
		CATV: document.getElementById('CATV').value,
		yard: document.getElementById('yard').value,
		notes: document.getElementById('notes').value,


	}
	//轉成JSON字串後存session
	sessionStorage.setItem('equipmentData', JSON.stringify(equipmentData));
}

function clear_session_equipment() {
	const equipmentData = {
		electric: "",
		gas: "",
		stove: "",
		waterWorks: "",
		sewage: "",
		kitchen: "",
		toilet: "",
		bathroom: "",
		basin: "",
		washingMachine: "",
		airConditioner: "",
		light: "",
		internet: "",
		trunkRoom: "",
		//
		roofBalcony: "",
		keyNum: "",
		elevator: "",
		autoLock: "",
		mailBox: "",
		deliveryBox: "",
		parking: "",
		pet: "",
		furniture: "",
		TV: "",
		CATV: "",
		yard: "",
		notes: "",
	}
	//轉成JSON字串後存session
	sessionStorage.setItem('equipmentData', JSON.stringify(equipmentData));
}


////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
//fee的部分


function get_session_fee() {
	const feeData = JSON.parse(sessionStorage.getItem('feeData'));
	if (!sessionStorage.getItem('feeData')) {
		return
	}
	document.getElementById('rent').value = feeData.rent;
	document.getElementById('deposit').value = feeData.deposit;
	document.getElementById('reward').value = feeData.reward;
	document.getElementById('commonExpenses').value = feeData.commonExpenses;
	document.getElementById('maxAmount').value = feeData.maxAmount;
	document.getElementById('renewal').value = feeData.renewal;
	document.getElementById('otherExpenses').value = feeData.otherExpenses;
	document.getElementById('payMethods').value = feeData.payMethods;
	document.getElementById('rentPayDate').value = feeData.rentPayDate;
	document.getElementById('commonExpensesDate').value = feeData.commonExpensesDate;
	document.getElementById('lessorName').value = feeData.lessorName;
	document.getElementById('lessorPhone').value = feeData.lessorPhone;
	document.getElementById('lessorAddress').value = feeData.lessorAddress;
	document.getElementById('managerName').value = feeData.managerName;
	document.getElementById('manegerPhone').value = feeData.manegerPhone;
	document.getElementById('managerAddress').value = feeData.managerAddress;
	document.getElementById('leaseDate').value = feeData.leaseDate;
	document.getElementById('leaseStartDate').value = feeData.leaseStartDate;
	document.getElementById('leaseEndDate').value = feeData.leaseEndDate;
	document.getElementById('checkDate').value = feeData.checkDate;
	document.getElementById('riderClause').value = feeData.riderClause;
}

function session_fee() {

	//從session取都道府名稱，傳到控制器，下一頁要用到
	//取道的值傳進隱藏的input，讓表單代進控制器到下一頁
	const prefName = sessionStorage.getItem("prefName");
	console.log(JSON.parse(prefName))
	document.getElementById("prefInput").value = JSON.parse(prefName);

	//Fee:feeData
	const feeData = {
		rent: document.getElementById('rent').value,
		deposit: document.getElementById('deposit').value,
		reward: document.getElementById('reward').value,
		commonExpenses: document.getElementById('commonExpenses').value,
		maxAmount: document.getElementById('maxAmount').value,
		renewal: document.getElementById('renewal').value,
		otherExpenses: document.getElementById('otherExpenses').value,
		payMethods: document.getElementById('payMethods').value,
		rentPayDate: document.getElementById('rentPayDate').value,
		commonExpensesDate: document.getElementById('commonExpensesDate').value,
		lessorName: document.getElementById('lessorName').value,
		lessorPhone: document.getElementById('lessorPhone').value,
		lessorAddress: document.getElementById('lessorAddress').value,
		managerName: document.getElementById('managerName').value,
		manegerPhone: document.getElementById('manegerPhone').value,
		managerAddress: document.getElementById('managerAddress').value,
		leaseDate: document.getElementById('leaseDate').value,
		leaseStartDate: document.getElementById('leaseStartDate').value,
		leaseEndDate: document.getElementById('leaseEndDate').value,
		checkDate: document.getElementById('checkDate').value,
		riderClause: document.getElementById('riderClause').value,
	};

	sessionStorage.setItem('feeData', JSON.stringify(feeData));
}

function clear_session_fee() {
	const feeData = {
		rent: "",
		deposit: "",
		reward: "",
		commonExpenses: "",
		maxAmount: "",
		renewal: "",
		otherExpenses: "",
		payMethods: "",
		rentPayDate: "",
		commonExpensesDate: "",
		lessorName: "",
		lessorPhone: "",
		lessorAddress: "",
		managerName: "",
		manegerPhone: "",
		managerAddress: "",
		leaseDate: "",
		leaseStartDate: "",
		leaseEndDate: "",
		checkDate: "",
		riderClause: "",
	};

	sessionStorage.setItem('feeData', JSON.stringify(feeData));
}

////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
//near的部分


function get_nearLine_option() {
	//取得totalData
	const stationDataJson = document.getElementById("stationDataJson").value
	const stationData = JSON.parse(stationDataJson);

	// data.lineName有多少線路，不重複
	const lineArr = [];
	stationData.forEach(function(data) {
		if (!lineArr.includes(data.lineName)) {
			lineArr.push(data.lineName);
		}
	});
	console.log(lineArr)

	//找完後做成option
	const nearLine = document.getElementById("nearLine");
	lineArr.forEach(function(line) {
		const opt = document.createElement("option");
		opt.value = line;
		opt.text = line;
		nearLine.appendChild(opt);
	});

	console.log(JSON.parse(stationDataJson))
}

function get_nearStation_option() {
	//取得totalData
	const stationDataJson = document.getElementById("stationDataJson").value
	const stationData = JSON.parse(stationDataJson);

	//取得select 選的值
	const nearLineName = document.getElementById("nearLine").value
	console.log(nearLineName)

	//依照選的線找車站
	const nearStationArr = []
	stationData.forEach(function(data) {
		if (nearLineName == data.lineName) {
			nearStationArr.push(data.stationName);
		}
	});

	//找完後做成option
	const nearStation = document.getElementById("nearStation");
	nearStation.innerHTML = ""
	nearStationArr.forEach(function(station) {
		const opt = document.createElement("option");
		opt.value = station;
		opt.text = station;
		nearStation.appendChild(opt);
	});

	console.log(nearStationArr)

}

function get_prefData() {
	const prefData1 = document.getElementById("hiddenInput1")
	const prefData2 = document.getElementById("hiddenInput2")
	const prefName = sessionStorage.getItem("prefName")
	prefData1.value = prefName
	prefData2.value = prefName
}


function set_near() {
//	session_near()
	//取德填寫得資料
	const nearLineName = document.getElementById("nearLine").value;
	const nearStationName = document.getElementById("nearStation").value;
	const warkingTime = document.getElementById("warkingTime").value;

	if (nearLineName == "" || nearStationName == "" || warkingTime == "") {
		return
	}

	//塞進session
	//Near:nearData
	const nearDataList = JSON.parse(sessionStorage.getItem("nearDataList")) || [];
	const nearData = {
		nearLine: nearLineName,
		nearStation: nearStationName,
		warkingTime: warkingTime
	}

	nearDataList.push(nearData)
	sessionStorage.setItem("nearDataList", JSON.stringify(nearDataList))
	set_created_nearData()

}

function set_created_nearData() {
	//取得要生成的ul 生成li
	const List = document.getElementById("nearDataList");
	const nearDataList = JSON.parse(sessionStorage.getItem("nearDataList")) || [];
	console.log(nearDataList)
	List.innerHTML = ''
	nearDataList.forEach(function(nearData) {
		const li = document.createElement("li");
		li.className = "nearData"
		li.textContent = nearData.nearLine + "  " + nearData.nearStation + "　徒步距離 " + nearData.warkingTime + " 分鐘。"
		List.appendChild(li);
	});

}


function dele_nearData() {
	const List = document.getElementById("nearDataList");
	List.removeChild(List.children[List.children.length - 1])
	const nearDataList = JSON.parse(sessionStorage.getItem("nearDataList"))
	nearDataList.splice(nearDataList.length - 1, 1);
	sessionStorage.setItem("nearDataList", JSON.stringify(nearDataList))
}

function session_near() {
	document.getElementById('near_form').addEventListener('submit', function(event) {
	const nearDataList = JSON.parse(sessionStorage.getItem("nearDataList"));
	if(nearDataList.length == 0){
		alert("少なくとも1つの近隣データを追加してください。")
		event.preventDefault();
		window.location.reload();
	}
});
}

////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
//complete的部分

function get_total_data() {
	get_session_building()
	get_session_equipment()
	get_session_fee()
}

function save_data() {
	//取得session全部資料

	const buildingData = JSON.parse(sessionStorage.getItem("buildingData"));
	const equipmentData = JSON.parse(sessionStorage.getItem('equipmentData'));
	const feeData = JSON.parse(sessionStorage.getItem('feeData'));
	const nearDataList = JSON.parse(sessionStorage.getItem('nearDataList'));
	const editState = sessionStorage.getItem('editState');
	const id = sessionStorage.getItem("buid")
	//依找編輯狀態，editState == true ，把每個東西加上buid

	const totalData = {
		buildingData: buildingData,
		equipmentData: equipmentData,
		feeData: feeData,
		nearDataList: nearDataList
	}

	if (editState == "true") {
		totalData.buildingData.buildingId = id
		totalData.equipmentData.buildingId = id
		totalData.feeData.buildingId = id
		if (totalData.nearDataList.lenght > 0) {

			totalData.nearDataList.foreach(function(near) {
				near.buid = id
			})
		}

	}

	console.log(totalData)
	//存進銀藏input
	const totalInput = document.getElementById("totalInput")
	totalInput.value = JSON.stringify(totalData)
	console.log(totalInput.value)

}

function save_switch() {
	alert("追加が成功しました")
	sessionStorage.removeItem("prefName");
	sessionStorage.removeItem("localName");
	sessionStorage.removeItem("buildingData");
	sessionStorage.removeItem("equipmentData");
	sessionStorage.removeItem("feeData");
	sessionStorage.removeItem("nearDataList");
	sessionStorage.removeItem("editState");
	sessionStorage.removeItem("buid");

	window.location.href = "http://localhost:8083/objTemp/objback";

}



