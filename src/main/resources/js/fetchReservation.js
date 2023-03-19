console.log("er i fetchReservation")

const urlActivityTime = "http://localhost:8080/activitytime";
let activityTimeList = [];
const ddSelectTime = document.getElementById("ddSelectTime");
window.addEventListener("load", loadActivityTime); //ændret til document DOMContentLoaded

async function loadActivityTime() {
    activityTimeList = await fetchAny(urlActivityTime);
    console.log(activityTimeList);
    activityTimeList.forEach(fillTimeDropDown);
}
function fillTimeDropDown(activityTime) {
    const el2 = document.createElement("option");
    el2.value = activityTime.timeSlotStart;
    el2.textContent = activityTime.timeSlotStart;
    console.log(activityTime.timeSlotStart);
    ddSelectTime.appendChild(el2);
}

function fetchAny(url) {
    console.log(url)
    return fetch(url).then((response) => response.json())
}