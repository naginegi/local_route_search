/**
 * 
 */
 
 function check(){
	
	const totalData = JSON.parse(document.getElementById("totalDataJson").value)
//	const totalDataJson = document.getElementById("totalDataJson")
	console.log(totalData)
	
	create_form()
}


function create_form(){
	const totalData = JSON.parse(document.getElementById("totalDataJson").value)
	const area = document.getElementById("all")
	totalData.forEach((total,index) => {

		const form = document.createElement("div")
		form.className = "form"
		form.innerHTML = ""
				
		const bu = document.createElement("div")
		bu.className = "bu"
		
		const h1 = document.createElement("h1")
		h1.innerHTML = total.buildingData.buName
		
		bu.appendChild(h1)
		
		//nearList
		const ul = document.createElement("ul")
		ul.className = "nearUl"
		total.nearList.forEach((near) => {
			const li = document.createElement("li")
			li.style = "margin: 1rem;"
			li.innerHTML = near.nearLine + " " + near.nearStation + " " + near.warkingTime + "分"			
			ul.appendChild(li)
		})
		
		bu.appendChild(ul)
		form.appendChild(bu)
		
		//roomBar
		const room = document.createElement("div")
		room.className = "room"

		const roomBar = document.createElement("div")
		roomBar.className = "roomBar"

		let span = document.createElement("span")
		span.innerHTML = "號室"
		span.className = "span"
		roomBar.appendChild(span)
		
		span = document.createElement("span")
		span.innerHTML = "賃金"
		span.className = "span"
		roomBar.appendChild(span)
		
		span = document.createElement("span")
		span.innerHTML = "床面積"
		span.className = "span"
		roomBar.appendChild(span)

		span = document.createElement("span")
		span.innerHTML = "間取り"
		span.className = "span"
		roomBar.appendChild(span)
		
		room.appendChild(roomBar)

		// fee room foreach		
		total.roomList.forEach((roomData,roomindex) => {		
			const roomContain = document.createElement("div")
			roomContain.className = "roomContain"
			
			let span = document.createElement("span")
			span.innerHTML = roomData.roomNum
			span.className = "span"
			roomContain.appendChild(span)
			
			span = document.createElement("span")
			span.innerHTML = total.feeList[roomindex].rent
			span.className = "span"
			roomContain.appendChild(span)
			
			span = document.createElement("span")
			span.innerHTML = roomData.roomArea
			span.className = "span"
			roomContain.appendChild(span)
			
			span = document.createElement("span")
			span.innerHTML = roomData.roomLayout
			span.className = "span"
			roomContain.appendChild(span)
			
			room.appendChild(roomContain)
		})
		
		form.appendChild(room)
		
		area.appendChild(form)
	});

		//組合

}