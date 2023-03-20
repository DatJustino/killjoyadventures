console.log("er i FetchEmplyee");

const urlEmployee = "http://localhost:8080/employees"; // skal hente fra egen database, kalder GetMapping endpoint her
let employeeList = [];


window.addEventListener("load", loadActivity); //ændret til document DOMContentLoaded

const ddSelectEmployee = document.getElementById("ddSelectEmployee");

async function loadActivity() {
    employeeList = await fetchAny(urlEmployee);
    console.log(employeeList);
  //  employeeList.forEach(fillActivityDropDown);
}

/*function fillActivityDropDown(employee) {
    const el = document.createElement("option");
    console.log(el);
    el.value = employee.employeeId;
    el.textContent = employee.employeeName;
    console.log(employee.employeeName);
    ddSelectEmployee.appendChild(el);
}*/

function fetchAny(url) {
    console.log(url);
    return fetch(url).then((response) => response.json());
    //Fetch sender http get request til url og får promise objekt. Then kaldes anonym funktion
    //som er en callback funktion fordi der går tid før den giver response
    //den laver response body til json. Response kan hedde hvad som helst
}
