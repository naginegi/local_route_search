/**
 * 
 */
 /*
function clearinnerHTML() {
	const prefRoute = document.getElementById("prefRoute");
	prefRoute.innerHTML = '';

	const localRoute = document.getElementById("localRoute");
	localRoute.innerHTML = '';

	//const select_local = document.getElementById("select_local");
	//select_local.innerHTML = '';

	//const localName = document.getElementById("localName");
	//localName.innerHTML = '';

}


function sear_prefRoute() {
	const prefRoute = document.getElementById("prefRoute");
	const prefName = document.getElementById("select_pref").value;
	fetch(`http://localhost:8083/api/search/prefRoute?prefName=${prefName}`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
	})
		.then(response => response.json())
		.then(data => {
			console.log(data)

			clearinnerHTML();
			data.str.forEach(element => {
				const prefRouteText = document.createElement('div');
				prefRouteText.textContent = element;
				prefRouteText.className = 'prefRouteText';
				prefRoute.appendChild(prefRouteText);
				//prefRoute.appendChild(document.createElement('br'));

			});


		})
		.catch(error => {
			console.error('Fetch error:', error);
		});

}

function localRouteSelect() {
	const prefName = document.getElementById("select_pref").value;
	const select_local = document.getElementById("select_local");

	fetch(`http://localhost:8083/api/search/searchLocalData?prefName=${prefName}`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
	})
		.then(response => response.json())
		.then(data => {
			console.log(data)
			//clearinnerHTML();
			select_local.innerHTML = '';
			data.localData.forEach(element => {
				const localOption = document.createElement('option');
				localOption.textContent = element.localName;
				localOption.value = element.localName;
				select_local.appendChild(localOption);
				//select_local.appendChild(document.createElement('br'));
				//console.log(element.localName);
			});
		})
		.catch(error => {
			console.error('Fetch error:', error);
		});


}




function sear_localRoute() {

	const localRoute = document.getElementById("localRoute");
	const localName = document.getElementById("select_local").value;
	fetch(`http://localhost:8083/api/search/localRoute?localName=${localName}`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
	})
		.then(response => response.json())
		.then(data => {
			console.log(data)
			clearinnerHTML();
			if (!data.str.length <= 0) {
				data.str.forEach(element => {
					const localRouteText = document.createElement('div');
					localRouteText.textContent = element;
					localRouteText.className = 'prefRouteText';
					localRoute.appendChild(localRouteText);
					//localRoute.appendChild(document.createElement('br'));

				});
			} else {
				const localRouteText = document.createElement('div');
				localRouteText.textContent = "路線のデータがありません";
				localRouteText.className = 'prefRouteText';
				localRoute.appendChild(localRouteText);
				//localRoute.appendChild(document.createElement('br'));
			}

		})
		.catch(error => {
			console.error('Fetch error:', error);
		});

}

function createLocalSelect() {
	const prefName = document.getElementById("prefName").value;
	const select_local = document.getElementById("localName");

	fetch(`http://localhost:8083/api/search/searchLocalData?prefName=${prefName}`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
	})
		.then(response => response.json())
		.then(data => {
			console.log(data)
			//clearinnerHTML();
			select_local.innerHTML = '';
			data.localData.forEach(element => {
				const localOption = document.createElement('option');
				localOption.textContent = element.localName;
				localOption.value = element.localName;
				select_local.appendChild(localOption);
				//select_local.appendChild(document.createElement('br'));
				//console.log(element.localName);
			});
		})
		.catch(error => {
			console.error('Fetch error:', error);
		});

}


function createLineSelect() {
	
	const prefName = document.getElementById("prefName").value;
	const address = document.getElementById("address");
	const lineName = document.getElementById("lineName");
	const localName = document.getElementById("localName").value;



	fetch(`http://localhost:8083/api/search/localRoute?localName=${localName}`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
	})
		.then(response => response.json())
		.then(data => {
			console.log(data)
			lineName.innerHTML = '';
			if (!data.str.length <= 0) {
				data.str.forEach(element => {
					const lineOption = document.createElement('option');
					lineOption.textContent = element;
					lineOption.value = element;
					lineName.appendChild(lineOption);
					//select_local.appendChild(document.createElement('br'));
					//console.log(element.localName);
				});

			} else {
				const lineOption = document.createElement('option');
				lineOption.textContent = "路線のデータがありません";
				lineOption.value = "";
				lineName.appendChild(lineOption);
			}
			const lineOption = document.createElement('option');
			lineOption.textContent = "路線を追加する";
			lineOption.value = "custom";
			lineName.appendChild(lineOption);


		})
		.catch(error => {
			console.error('Fetch error:', error);
		});
	
	address.value = `${prefName}${localName}`;
	//console.log(address);
}

function createInputLine(){
	
	const customInput = document.getElementById("customInput");
	const lineName = document.getElementById("lineName").value;

	if(lineName == "custom"){
		customInput.style.display = "inline-block";
	}else{
		customInput.style.display = "none";
	}
}


function create() {
	const customInput = document.getElementById("customInput").value;

	let pref = document.getElementById("prefName").value;
	let local = document.getElementById("localName").value;
	let station = document.getElementById("stationName").value;
	let addr = document.getElementById("address").value;
	let line = document.getElementById("lineName").value;
	// const value = localName;
	// console.log(value)
	let createData;
	if(line == "custom"){
		createData = {
		prefName: pref,
		localName: local,
		stationName: station,
		address: addr,
		lineName: customInput
		};
	}else{
		createData = {
		prefName: pref,
		localName: local,
		stationName: station,
		address: addr,
		lineName: line
		};
	}
	
	console.log(createData);

	fetch(`http://localhost:8083/api/search/createRoute`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(createData),
	})
		.then(response => response.json())
		.then(data => {
			console.log(data)


			if (data.msgCode == "SUCCESSFUL") {
				alert("登録が成功しました");
			}
			if (data.msgCode == "INPUT_ERROR") {
				alert("入力エラー");
			}
			if (data.msgCode == "AREA_NOT_FOUND") {
				alert("このエリアは存在しません");
			}
			if (data.msgCode == "ADDRESS_ERROR") {
				alert("住所エラー");
			}
			if (data.msgCode == "ADDRESS_EXISTED") {
				alert("住所は既に存在しています");
			}
			if (data.msgCode == "STATION_EXISTED") {
				alert("駅は既に存在しています");
			}

		})
		.catch(error => {
			console.error('Fetch error:', error);
		});

}

*/
///////////////////////////////////////////////////


function checkselectPrefValue(){
	 const prefName = document.getElementById("select_pref");
//	 const localName = document.getElementById("select_local");
	 const prefBtn = document.getElementById("select_pref_btn");
//	 const localBtn = document.getElementById("select_local_btn");

	 if (prefName.value.trim() == '') {
            prefBtn.style.display = 'none';
//            localName.style.display = 'none';
//            localBtn.style.display = 'none';
        } else {
            prefBtn.style.display = 'block';
//            localName.style.display = 'block';
//            localBtn.style.display = 'block';
        }
	}

function checkselectLocalValue(){
	 const localName = document.getElementById("select_local"); 
	 const searchBtn = document.getElementById("select_local_btn");

	 if (localName.value.trim() == '') {
            searchBtn.style.display = 'none';
        } else {
            searchBtn.style.display = 'block';
        }
}

//function checkParams(){
//	 const prefName = document.getElementById("prefName");
//	 const localName = document.getElementById("localName");
//	 const lineName = document.getElementById("lineName");
//	 const stationName = document.getElementById("stationName");
//	 const address = document.getElementById("address");
//	 const code = document.getElementById("code");
////	 console.log(code.attributes[2].valuecode);
//	 alert(code.attributes[2].value)
//}



