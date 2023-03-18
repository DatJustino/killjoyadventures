console.log("er i js");
const urlActivity = "http://localhost:8080/activity"; // skal hente fra egen database, kalder GetMapping endpoint her
const urlActivityTime = "http://localhost:8080/activitytime";
let activityForm;
let activityList = [];
let activityTimeList = [];
let body = {};

// frem for window 'load'
/*window.addEventListener("load", loadActivity);
window.addEventListener("load", loadActivityTime);*/
document.addEventListener("DOMContentLoaded", createFormEventListener); //ændret til document DOMContentLoaded
document.addEventListener("DOMContentLoaded", loadActivityTime); //ændret til document DOMContentLoaded
document.addEventListener("DOMContentLoaded", loadActivity); //ændret til document DOMContentLoaded

const ddSelectTime = document.getElementById("ddSelectTime");
const ddSelectActivity = document.getElementById("ddSelectActivity");
const pbPostActivity = document.getElementById("pbPostActivity");
pbPostActivity.addEventListener('click', actionPostAllActivity);

async function loadActivity() {
    activityList = await fetchAny(urlActivity);
    console.log(activityList);
    activityList.forEach(fillActivityDropDown);
}

async function loadActivityTime() {
    activityTimeList = await fetchAny(urlActivityTime);
    console.log(activityTimeList);
    activityTimeList.forEach(fillTimeDropDown);
}

function fillActivityDropDown(activity) {
    const el = document.createElement("option");
    console.log(el);
    el.value = activity.activityName;
    el.textContent = activity.activityName;
    console.log(activity.activityName);
    ddSelectActivity.appendChild(el);
}

function fillTimeDropDown(activityTime) {
    const el2 = document.createElement("option");
    el2.value = activityTime.timeSlotStart;
    el2.textContent = activityTime.timeSlotStart;
    console.log(activityTime.timeSlotStart);
    ddSelectTime.appendChild(el2);
}

function createFormEventListener() {
    activityForm = document.getElementById("activityForm");
    activityForm.addEventListener("submit", handleFormSubmit);
}

async function handleFormSubmit(event) {
    //Vi handler submit knappen og eventet i stedet for default html behaviour
        event.preventDefault();
        const form = event.target;
        const url = form.action;
        const formData = new FormData(form);
        fetch(url, {
            method: 'POST',
            body: formData
        })
            .then(response => response.text())
            .then(data => {
                alert("Activity Applied successfully!, we will send you an email if we can confirm this booking");
                form.reset();
            })
            .catch(error => {
                alert("There was an error saving the activity.");
                console.error(error);
            });
    }

async function postFormData(url, formData) {
    const plainFormData = Object.fromEntries(formData.entries());
    console.log(plainFormData);
    const line = ddSelectActivity.options[ddSelectActivity.selectedIndex].text;
    const time = ddSelectTime.options[ddSelectTime.selectedIndex].text;
    plainFormData.activity = line;
    plainFormData.timeslot = time;
    const formDataJsonString = JSON.stringify(plainFormData);

    const fetchOptions = {
        method: "POST",
        headers: {
            "content-type": "application/json"
        },
        body: formDataJsonString
    };
    const response = await fetch(url, fetchOptions);
    if (!response.ok) {
        const errorMessage = await response.text();
        throw new Error(errorMessage);
    }
    return response.json();
}

function fetchAny(url) {
    console.log(url);
    return fetch(url).then((response) => response.json());
    //Fetch sender http get request til url og får promise objekt. Then kaldes anonym funktion
    //som er en callback funktion fordi der går tid før den giver response
    //den laver response body til json. Response kan hedde hvad som helst
}


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
}
