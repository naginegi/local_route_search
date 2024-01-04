/**
 * 
 */
 
// console.log("123456");

function get_building_data(){
	//取得bu資料
	const buildingData = JSON.parse(document.getElementById("buildingData").value)
	
	console.log(buildingData)
	
	//印到畫面上
	/////
	//好像用不到了
	/////
	
}

function check_buid(id){
	console.log("check:"+id)
	const totalData = JSON.parse(document.getElementById("buildingData").value)
	console.log(totalData)
	totalData.buRes.forEach(function(bu) {
		if(bu.buildingId == id){
			sessionStorage.setItem("buildingData",JSON.stringify(bu))
			sessionStorage.setItem("prefName",JSON.stringify(bu.buildingPref))
			sessionStorage.setItem("localName",JSON.stringify(bu.buildingLocal))
			
		}
	});
	
	totalData.eqRes.forEach(function(eq) {
		if(eq.buildingId == id){
			sessionStorage.setItem("equipmentData",JSON.stringify(eq))
		}
	});
	
	totalData.feeRes.forEach(function(fee) {
		if(fee.buildingId == id){
			sessionStorage.setItem("feeData",JSON.stringify(fee))
		}
	});
	
	const arr = []
	totalData.nearRes.forEach(function(near) {
		if(near.buId == id){
			arr.push(near)
		}
	});
	sessionStorage.setItem("nearDataList",JSON.stringify(arr))
	sessionStorage.setItem("editState",true)
	sessionStorage.setItem("buid",id)
	
}

function dele_buid(id){
	console.log("dele:"+id)
}

function get_total_data(){
	const totalData = JSON.parse(document.getElementById("totalData").value)
	console.log(totalData)
	
	
	document.getElementById('buildingName').value = totalData.buildingData.buildingName;
	document.getElementById('buildingAddress').value = totalData.buildingData.buildingAddress;
	document.getElementById('buildingType').value = totalData.buildingData.buildingType;
	document.getElementById('buildingMaterials').value = totalData.buildingData.buildingMaterials;
	document.getElementById('buildingArea').value = totalData.buildingData.buildingArea;
	document.getElementById('roomNum').value = totalData.buildingData.roomNum;
	document.getElementById('roomLayout').value = totalData.buildingData.roomLayout;
	document.getElementById('yearOfBuild').value = totalData.buildingData.yearOfBuild;
	document.getElementById('buildingPref').value = totalData.buildingData.buildingPref;
	document.getElementById('buildingLocal').value = totalData.buildingData.buildingLocal;
	//
	document.getElementById('electric').value = totalData.equipmentData.electric;
	document.getElementById('gas').value = totalData.equipmentData.gas;
	document.getElementById('stove').value = totalData.equipmentData.stove;
	document.getElementById('waterWorks').value = totalData.equipmentData.waterWorks;
	document.getElementById('sewage').value = totalData.equipmentData.sewage;
	document.getElementById('kitchen').value = totalData.equipmentData.kitchen;
	document.getElementById('toilet').value = totalData.equipmentData.toilet;
	document.getElementById('bathroom').value = totalData.equipmentData.bathroom;
	document.getElementById('basin').value = totalData.equipmentData.basin;
	document.getElementById('washingMachine').value = totalData.equipmentData.washingMachine;
	document.getElementById('airConditioner').value = totalData.equipmentData.airConditioner;
	document.getElementById('light').value = totalData.equipmentData.light;
	document.getElementById('internet').value = totalData.equipmentData.internet;
	document.getElementById('trunkRoom').value = totalData.equipmentData.trunkRoom;
	//
	document.getElementById('roofBalcony').value = totalData.equipmentData.roofBalcony;
	document.getElementById('keyNum').value = totalData.equipmentData.keyNum;
	document.getElementById('elevator').value = totalData.equipmentData.elevator;
	document.getElementById('autoLock').value = totalData.equipmentData.autoLock;
	document.getElementById('mailBox').value = totalData.equipmentData.mailBox;
	document.getElementById('deliveryBox').value = totalData.equipmentData.deliveryBox;
	document.getElementById('parking').value = totalData.equipmentData.parking;
	document.getElementById('pet').value = totalData.equipmentData.pet;
	document.getElementById('furniture').value = totalData.equipmentData.furniture;
	document.getElementById('TV').value = totalData.equipmentData.TV;
	document.getElementById('CATV').value = totalData.equipmentData.CATV;
	document.getElementById('yard').value = totalData.equipmentData.yard;
	document.getElementById('notes').value = totalData.equipmentData.notes;
	//
	document.getElementById('rent').value = totalData.feeData.rent;
	document.getElementById('deposit').value = totalData.feeData.deposit;
	document.getElementById('reward').value = totalData.feeData.reward;
	document.getElementById('commonExpenses').value = totalData.feeData.commonExpenses;
	document.getElementById('maxAmount').value = totalData.feeData.maxAmount;
	document.getElementById('renewal').value = totalData.feeData.renewal;
	document.getElementById('otherExpenses').value = totalData.feeData.otherExpenses;
	document.getElementById('payMethods').value = totalData.feeData.payMethods;
	document.getElementById('rentPayDate').value = totalData.feeData.rentPayDate;
	document.getElementById('commonExpensesDate').value = totalData.feeData.commonExpensesDate;
	document.getElementById('lessorName').value = totalData.feeData.lessorName;
	document.getElementById('lessorPhone').value = totalData.feeData.lessorPhone;
	document.getElementById('lessorAddress').value = totalData.feeData.lessorAddress;
	document.getElementById('managerName').value = totalData.feeData.managerName;
	document.getElementById('manegerPhone').value = totalData.feeData.manegerPhone;
	document.getElementById('managerAddress').value = totalData.feeData.managerAddress;
	document.getElementById('leaseDate').value = totalData.feeData.leaseDate;
	document.getElementById('leaseStartDate').value = totalData.feeData.leaseStartDate;
	document.getElementById('leaseEndDate').value = totalData.feeData.leaseEndDate;
	document.getElementById('checkDate').value = totalData.feeData.checkDate;
	document.getElementById('riderClause').value = totalData.feeData.riderClause;
	//
	
//	const nearLineName = document.getElementById("nearLine").value;
//	const nearStationName = document.getElementById("nearStation").value;
//	const warkingTime = document.getElementById("warkingTime").value;
	
	const List = document.getElementById("nearDataList");
	const nearDataList = totalData.nearDataList;
	nearDataList.forEach(function(nearData) {
	const li = document.createElement("li");
	li.className = "nearData"
	li.textContent = nearData.nearLine + "  " + nearData.nearStation + "　徒步距離 " + nearData.warkingTime + " 分鐘。"
	List.appendChild(li);
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}