let urlPre="";

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
                "hashedPassword": hash(password),
                "boulders": []
            }
            axios.post(urlPre + "/userApp/user", user).then(() => {
                $('#addUserForm').modal('hide')
            });
    }
}

function getData() {
    axios.get(urlPre + "/userApp/user")
        .then(response => {login(response.data);});
}

function login(users) {
    document.getElementById("invalidLoginErrorMessage").setAttribute("style","display: hidden");
    let name = document.getElementById("usernameInput");
    let password = document.getElementById("passwordInput");
    for (let i=0; i<users.length; i++) {
        if (name.value===users[i].username.toString() && hash(password.value)===users[i].hashedPassword.toString()) {
            sessionStorage.setItem("userID",users[i].id);
            window.location = "html/bucketList.html";
        }
    }
    document.getElementById("invalidLoginErrorMessage").setAttribute("style","");
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

function hash(s) {
    var a = 1, c = 0, h, o;
    if (s) {
        a = 0;
        /*jshint plusplus:false bitwise:false*/
        for (h = s.length - 1; h >= 0; h--) {
            o = s.charCodeAt(h);
            a = (a<<6&268435455) + o + (o<<14);
            c = a & 266338304;
            a = c!==0?a^c>>21:a;
        }
    }
    return String(a);
}
