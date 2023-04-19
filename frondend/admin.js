const url = "http://localhost:3000/" 

document.getElementById("getUsersButton").addEventListener("click", getusers);
document.getElementById("getUsersbyuser_idButton").addEventListener("click", getuserbyid);

//Get all users.
async function getusers() { //getusers is just a function name.
     
    let response = await fetch(url + "user"); //user is the table name in database

    console.log(response);

    if(response.status === 200){

        let data = await response.json();

        console.log(data);

        for(let user of data) {

            let row = document.createElement("tr");

            let cell = document.createElement("td");
            cell.innerHTML = user.id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = user.username;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = user.password;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = user.fname;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = user.lname;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = user.email;
            row.appendChild(cell6);

            // let cell7 = document.createElement("td");
            // cell7.innerHTML = user.role_id;
            // row.appendChild(cell7);

            document.getElementById("UsersBody").appendChild(row);
        }
    }
}

// Get user by id.
async function getuserbyid() {

    let user_id  = document.getElementById("myInput").value;
     
    let response = await fetch(url + "user/" + user_id);

    console.log(response);

    if(response.status === 200){

        let data = await response.json();

        console.log(data);

        for(let user in data) {
                                
            let row = document.createElement("tr");

            let cell = document.createElement("td");
            cell.innerHTML = data.id;
            row.appendChild(cell);

            let cell2 = document.createElement("td");
            cell2.innerHTML = data.username;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = data.password;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = data.fname;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = data.lname;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = data.email;
            row.appendChild(cell6);

            // let cell7 = document.createElement("td");
            // cell7.innerHTML = user.role_id;
            // row.appendChild(cell7);

            document.getElementById("UsersBody").appendChild(row);
            
            break;
        }
    }
}


const logOut = () => {
    window.localStorage.clear();
    window.location.href = localurl + 'login.html';
}






