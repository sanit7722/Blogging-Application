export const isLoggedIn=()=>{
    let data=localStorage.getItem("data")
    if(data==null){
        return false;
    }
    else{
        return true;
    }
};

export const doLogin=(data, next)=>{
    localStorage.setItem("data",JSON.stringify(data));
    next()
};

export const doLogout=(next)=>{
    localStorage.removeItem("data");
    next()
};

export const getCurrUserDetail=()=>{

    if(isLoggedIn){
        return JSON.parse( localStorage.getItem("data"));
    }
    else return false;

};
