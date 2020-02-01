let urlPre="";
let valid = true;

function addUser() {
    let name = document.getElementById("userName").value;
    let password = document.getElementById("userPassword").value;
    let passwordConfirm = document.getElementById("userPasswordConfirm").value;
    if (name === "" || password === "") {
        document.getElementById("noEntryErrorMessage").setAttribute("style","");
    } else if (name.length > 20) {
        document.getElementById("nameTooLongErrorMessage").setAttribute("style","");
    } else if (password !== passwordConfirm) {
        document.getElementById("differentPasswordsErrorMessage").setAttribute("style","");
    } else {
            let user = {
                "username": name,
                "hashedPassword": password,
                "boulders": []
            }
            axios.post(urlPre + "/userApp/user", user).then(() => {
                $('#addUserForm').modal('hide')
            });
    }
}

function resetAddModal() {
    let name = document.getElementById("userName");
    let password = document.getElementById("userPassword");
    let passwordConfirm = document.getElementById("userPasswordConfirm");
    document.getElementById("noEntryErrorMessage").setAttribute("style", "display: none");
    document.getElementById("nameTooLongErrorMessage").setAttribute("style","display: none");
    document.getElementById("nonUniqueNameErrorMessage").setAttribute("style","display: none");
    document.getElementById("differentPasswordsErrorMessage").setAttribute("style","display: none");
    name.value = "";
    password.value="";
    passwordConfirm.value="";
}
