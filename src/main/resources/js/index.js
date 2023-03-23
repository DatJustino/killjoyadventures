console.log("er i index.js");

const urlActivity = "http://localhost:8080/admin/activities"; // skal hente fra egen database, kalder GetMapping endpoint her
let activityList = [];
const tblActivity = document.getElementById("tblActivity")
document.addEventListener('DOMContentLoaded', loadActivity);
const ddSelectActivity = document.getElementById("ddSelectActivity");

const activitygrit = document.getElementById('activitygrit');

async function loadActivity() {
    activityList = await fetchAny(urlActivity);
    console.log(activityList);
    //activityList.forEach(createTable)
    displayPokemon(activityList);
}

const displayPokemon = (activityList) => {
    console.log(activityList);
    const pokemonHTMLString = activityList
        .map(
            (activity) => `
        <li class="card">
            <!--<img class="card-image" src="\${pokeman.image}"/>-->
            <h2 class="card-title">${activity.activityId}. ${activity.activityName}</h2>
            <p class="card-subtitle">Type: "Type"</p>
        </li>
    `
        )
        .join('');
    activitygrit.innerHTML = pokemonHTMLString;
};


function fetchAny(url) {
    console.log(url);
    return fetch(url).then((response) => response.json());
}

/*function createTable(activity) {
    console.log("creating table " + activity)
    if (!activity.activityId) return;

    let cellCount = 0
    let rowCount = tblActivity.rows.length
    let row = tblActivity.insertRow(rowCount)
    row.id = activity.activityId;

    let cell = row.insertCell(cellCount++)
    cell.innerHTML = activity.activityId

    cell = row.insertCell(cellCount++)
    cell.innerHTML = activity.activityName

    cell = row.insertCell(cellCount++)
    let atag = document.createElement("a")
    atag.setAttribute("href", activity.href)
    atag.innerText = activity.activityId
    cell.appendChild(atag)

    cell = row.insertCell(cellCount++)
    cell.innerHTML = "så"
}*/

