console.log("er i fetchActivity");

const urlActivity = "http://localhost:8080/admin/activities"; // skal hente fra egen database, kalder GetMapping endpoint her
let activityList = [];

document.addEventListener('DOMContentLoaded', loadActivity);

const ddSelectActivity = document.getElementById("ddSelectActivity");

async function loadActivity() {
    activityList = await fetchAny(urlActivity);
    actionCreateTable()
    //console.log(activityList);
  //  activityList.forEach(fillActivityDropDown);
}
function fetchAny(url) {
    console.log(url);
    return fetch(url).then((response) => response.json());
    //Fetch sender http get request til url og får promise objekt. Then kaldes anonym funktion
    //som er en callback funktion fordi der går tid før den giver response
    //den laver response body til json. Response kan hedde hvad som helst
}
/*
function fillActivityDropDown(activity) {
    const el = document.createElement("option");
    console.log(el);
    el.value = activity.activityName;
    el.textContent = activity.activityName;
    console.log(activity.activityName);
    ddSelectActivity.appendChild(el);
}*/



/* DEPRECATED FOR NOW
function postActivity(activity) {
    const postActivityRequest = {
        method: "POST",
        headers: {"content-type": "application/json"},
        body: JSON.stringify(activity)
    };
    fetch(urlActivity, postActivityRequest)
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            console.log("Activity posted successfully:", activity);
        })
        .catch(error => console.error("Error posting activity:", error));
}

function actionPostAllActivity() {
    if (activityList.length > 0) {
        console.log("Posting Activity List:");
        activityList.forEach(postActivity)
    } else {
        console.log("No activities to post.");
    }
}*/
