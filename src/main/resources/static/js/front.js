/*
function searchLocals() {

	const local = document.getElementById("local");
	const prefName = document.getElementById("select_pref").value;
	fetch(`http://localhost:8083/api/search/searchLocalData?prefName=${prefName}`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
	})
		.then(response => response.json())
		.then(data => {
			console.log(data)
			clearinnerHTML();
			data.localData.forEach(element => {
				const localText = document.createElement('div');
				localText.textContent = element.localName;
				localText.className = 'localText'; 
				local.appendChild(localText);
				local.appendChild(document.createElement('br'));
				console.log(element.localName);
			});
		})
		.catch(error => {
			console.error('Fetch error:', error);
		});

}

function clearinnerHTML() {
//	const local = document.getElementById("local");
//	const line = document.getElementById("line");
//	const station = document.getElementById("station")
//	local.innerHTML = '';
//	line.innerHTML = '';
//	station.innerHTML = '';
}

function searchLines() {
	const station = document.getElementById("station")
	const prefName = document.getElementById("select_pref").value;
	const line = document.getElementById("line")
	fetch(`http://localhost:8083/api/search/prefRoute?prefName=${prefName}`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
	})
		.then(response => response.json())
		.then(data => {
			clearinnerHTML();
			data.str.forEach((option, index) => {
				const checkboxContainer = document.createElement('label');
                checkboxContainer.className = 'checkbox-container';

                const checkbox = document.createElement('input');
                checkbox.type = 'checkbox';
                checkbox.value = option;
                checkbox.id = `checkbox-${index}`;
                checkbox.className = 'line';

                const label = document.createElement('span');
                label.className = 'checkmark';
                label.appendChild(document.createTextNode(option));

                checkboxContainer.appendChild(checkbox);
                checkboxContainer.appendChild(label);
                checkboxContainer.appendChild(document.createElement('br'));

                line.appendChild(checkboxContainer);
			});
		})
		.catch(error => {
			console.error('Fetch error:', error);
		});

}

function searchStation() {
	const station = document.getElementById("station")
	const checkboxes = document.querySelectorAll('.line:checked');
	const values = Array.from(checkboxes).map(checkbox => checkbox.value);

	console.log(values);
	if (values.length === 0) {
		return; 
	}
	fetch(`http://localhost:8083/api/search/searchStationData?lineName=${values}`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
	})
		.then(response => response.json())
		.then(data => {
			// console.log(data)
			total_data = data;
			console.log(total_data);
			station.innerHTML = ''; 
			total_data.stationData.forEach(element => {
				const listItem = document.createElement('div'); 
				listItem.textContent = element.stationName;
				listItem.className = 'stationName'; 
				station.appendChild(listItem); 
				station.appendChild(document.createElement('br'));

			});
		})
		.catch(error => {
			console.error('Fetch error:', error);
		});

}
*/
/////////////////////////////////


function checkselectPrefValue(){
	 const prefName = document.getElementById("select_pref");
	 const searchBtn = document.getElementById("select_btn");
	 console.log(prefName.value)
	 if (prefName.value.trim() == '') {
            searchBtn.style.display = 'none';
        } else {
            searchBtn.style.display = 'block';
        }
	}


function checkselectPrefLineValue(){
	 const prefName = document.getElementById("select_pref_line");
	 const prefLineBtn = document.getElementById("select_pref_line_btn");
	 if (prefName.value.trim() == '') {
            prefLineBtn.style.display = 'none';
        } else {
            prefLineBtn.style.display = 'block';
        }
	}


function checkselectLineStationValue(){
        // 获取所有名称为 "checkbox" 的复选框元素
        const checkboxes = document.getElementsByName("checkbox");
		const selectLineStationBtn = document.getElementById("select_line_station_btn");
        // 检查是否至少有一个复选框被选中
        let atLeastOneChecked = false;
        for (let i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                atLeastOneChecked = true;
                break;
            }
        }
		if(atLeastOneChecked == true){
			selectLineStationBtn.style.display = 'block';
		}else{
			selectLineStationBtn.style.display = 'none';
		}
		

	}




