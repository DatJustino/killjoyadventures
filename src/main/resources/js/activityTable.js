console.log("vi er i activityTable")

document.addEventListener('DOMContentLoaded', actionCreateTable)

const tblActivity = document.getElementById("tblActivity")

function actionCreateTable() {
    console.log("vi er i actionCreateTable")
    console.log(activityList)
    activityList.forEach(createTable)
}

function createTable(activity) {
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
}

