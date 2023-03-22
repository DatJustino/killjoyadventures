console.log("Vi er i formReservation")

document.addEventListener('DOMContentLoaded', createFormEventListener);
let formReservation;

function createFormEventListener(){
    formReservation = document.getElementById("formReservation");
    formReservation.addEventListener("submit", handleFormSubmit);
}
//const ddSelectActivity = document.getElementById("ddSelectActivity")


async function handleFormSubmit(event) {
    //Vi handler submit her, i stedet for default html behaviour
    event.preventDefault();
    const form = event.currentTarget;
    const url = form.action;
    console.log(form)
    console.log(url)
    console.log(form === formReservation)
    try {
        const formData = new FormData(form);
        const responseData = await postFormData(url, formData);
        // Use the responseData object to handle the response
        if (responseData) {
            alert(formData.get("navn") + " er oprettet");
            // Redirect to the desired page
            const homeUrl = "/admin/activities.html";
            window.location.href = homeUrl;
        }
    } catch (error) {
        alert(error.message);
        console.log(error);
    }
}


async function postFormData(url, formData) {
    const plainFormData = Object.fromEntries(formData.entries())
    const ix = ddSelectActivity.selectedIndex;
    const linje = ddSelectActivity[ix]
    plainFormData.activity = linje.activity
    console.log("plainFormData: ", plainFormData)
    const formDataJsonString = JSON.stringify(plainFormData)
    const fetchOptions = {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: formDataJsonString
    }

    const response = await fetch(url, fetchOptions)

    if (!response.ok) {
        const errorMessage = await response.text()
        throw new Error(errorMessage)
    }
    return response.json();
}