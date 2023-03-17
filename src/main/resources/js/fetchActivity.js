console.log("er i js")
const urlActivity = "http://localhost:8080/activity" //skal hente fra egen database, kalder getmapping endpoint her
let activityList = []
const ddSelectActivity = document.getElementById("ddSelectActivity")

document.addEventListener("DOMContentLoaded", loadActivity) //ændret til document DOMContentLoaded
//frem for window 'load'

async function loadActivity(){
    activityList = await fetchAny(urlActivity);
    console.log(activityList)
    activityList.forEach(fillActivityDropDown)
}

function fillActivityDropDown(activity) {
    const el = document.createElement("option")
    console.log(el)
    el.value = activity.activityId
    el.textContent = activity.activityId
    el.textContent += " så" //test
    console.log(activity.activityId)
    ddSelectActivity.appendChild(el)
}

function fetchAny(url) {
    console.log(url)
    return fetch(url).then((response) => response.json())
    //fetch sender http get request til url og får promise objekt. then kaldes anonym funktion
    //som er en callback funktion fordi der går tid før den giver response
    //den laver reponse's body til json. Response kan hedde hvad som helst
}

