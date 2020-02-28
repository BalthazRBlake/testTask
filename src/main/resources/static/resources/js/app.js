const empList = document.getElementById('empList');
const searchBtn = document.getElementById('searchName');
const formBtn = document.getElementById('cancel');

loadEventListeners();

function loadEventListeners(){
    document.addEventListener('DOMContentLoaded', loadTable);
    empList.addEventListener('click', showDetails);
    searchBtn.addEventListener('click', searchEmployees);
    formBtn.addEventListener('click', cancel);
}

function loadTable(){
    $('#table').load("/home");
}

function showDetails(e){
    e.preventDefault();

    if(e.target.classList.contains('viewDetails')){
        let str = e.target.href;
        let urlStarts = str.indexOf('/home');
        let url = str.substring(urlStarts, str.length);

        $('#empDetails').load(url);
    }

    if(e.target.classList.contains('editEmployee')){
        let str = e.target.href;
        let urlStarts = str.indexOf('/home');
        let url = str.substring(urlStarts, str.length);

        $('#editForm').load(url);
     }

    if(e.target.classList.contains('deleteEmployee')){
        let str = e.target.href;
        let urlStarts = str.indexOf('/home');
        let url = str.substring(urlStarts, str.length);

        $('#table').load(url);
    }
}

function searchEmployees(e){
    e.preventDefault();

    if(e.target.classList.contains('searchEmp')){
        let url = '/home/search/' + searchBtn.querySelector('input').value;
        //console.log(url);
        $('#table').load(url);
    }
    if(e.target.classList.contains('reset')){
            $('#table').load("/home");
    }
}

function cancel(e){
    e.preventDefault();
    console.log(e.target.classList.contains('buttons'));

    if(e.target.classList.contains('buttons')){
        $('#editForm').load("/home/cancel");
    }
}