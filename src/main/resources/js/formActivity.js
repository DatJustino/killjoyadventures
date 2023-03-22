console.log("Vi er i formActivity");

let formActivity;

function createFormEventListenerActivity() {
    formActivity = document.getElementById("formActivity");
    formActivity.addEventListener("submit", handleFormSubmitActivity);
}

async function handleFormSubmitActivity(event) {
    event.preventDefault();
    const form = event.currentTarget;
    const url = form.action;

    try {
        const formData = new FormData(form);
        const responseData = await postFormData(url, formData);
        if (responseData) {
            alert(formData.get("navn") + " er oprettet");
            const homeUrl = "/admin/activities.html";
            window.location.href = homeUrl;
        }
    } catch (error) {
        alert(error.message);
        console.log(error);
    }
}

async function postFormData(url, formData) {
    const plainFormData = Object.fromEntries(formData.entries());
    const formDataJsonString = JSON.stringify(plainFormData);
    const fetchOptions = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: formDataJsonString,
    };
    const response = await fetch(url, fetchOptions);
    if (!response.ok) {
        const errorMessage = await response.text();
        throw new Error(errorMessage);
    }
    return response.json();
}

document.addEventListener("DOMContentLoaded", createFormEventListenerActivity);
