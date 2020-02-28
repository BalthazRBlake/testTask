const empList = document.getElementById('empList');
const formBtn = document.getElementById('formBtn');
const searchBtn = document.getElementById('searchName');
//const formBtn = document.getElementById('cancel');
const pageSize = document.getElementById('size');

loadEventListeners();

function loadEventListeners(){
    document.addEventListener('DOMContentLoaded', loadTable);
    empList.addEventListener('click', showDetails);
    searchBtn.addEventListener('click', searchEmployees);
    formBtn.addEventListener('click', buttons);
    pageSize.addEventListener('click', pagination);
}

function loadTable(){
    $('#table').load("/home/page/1/10");
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

    if(e.target.classList.contains('currentPage')){
            let str = e.target.href;
            let urlStarts = str.indexOf('/home');
            let url = str.substring(urlStarts, str.length) + '/' + document.getElementById('size').value;
            $('#table').load(url);
    }
}

function searchEmployees(e){
    e.preventDefault();

    if(e.target.classList.contains('searchEmp')){
        let url = '/home/search/' + searchBtn.querySelector('input').value;
        $('#table').load(url);
    }
    if(e.target.classList.contains('reset')){
            $('#table').load("/home/page/1/10");
    }
}

function pagination(e){
    let url = '/home/page/1/' + document.getElementById('size').value;
    $('#table').load(url);
}

function buttons(e){
    e.preventDefault();
    console.log(e.target.classList.contains('buttons'));

/*    if(e.target.classList.contains('buttons')){
        $('#editForm').load("/home/cancel");
    }*/
}