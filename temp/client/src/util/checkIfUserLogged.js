function checkIfUserLogged() {
    if(localStorage.getItem('loggedUser')){
        return JSON.parse(localStorage.getItem('loggedUser'));
    }else{
        return null;
    }
}

export default checkIfUserLogged;