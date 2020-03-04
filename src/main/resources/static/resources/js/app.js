const empList = document.getElementById('empList');
const formBtn = document.getElementById('formBtn');
const searchBtn = document.getElementById('searchName');
const pageSize = document.getElementById('size');

let page = 1;

loadEventListeners();

function loadEventListeners(){
    document.addEventListener('DOMContentLoaded', loadTable);
    empList.addEventListener('click', showDetails);
    searchBtn.addEventListener('click', searchEmployees);
    formBtn.addEventListener('click', buttons);
    pageSize.addEventListener('change', pagination);
}

function loadTable(){
    $('#table').load('/home/page/' + page + '/' + document.getElementById('size').value);
    $('#form').load('/home/edit/0');
    $('#empDetails').load('/home/details/0');
}

function showDetails(e){
    e.preventDefault();

    if(e.target.classList.contains('viewDetails')){
        let str = e.target.href;
        let urlStarts = str.indexOf('/home');
        let url = str.substring(urlStarts, str.length);
        $.ajax({
            type: 'GET',
            url: url,
            success: function(result){
                $('#empDetails').html(result);
            }
        });

    }

    if(e.target.classList.contains('editEmployee')){
        let str = e.target.href;
        let urlStarts = str.indexOf('/home');
        let url = str.substring(urlStarts, str.length);
        $.ajax({
            type: 'GET',
            url: url,
            success: function(result){
                $('#form').html(result);
            }
        });
     }

    if(e.target.classList.contains('deleteEmployee')){
        let str = e.target.href;
        let urlStarts = str.indexOf('/home');
        let url = str.substring(urlStarts, str.length);
        $.ajax({
            type: 'GET',
            url: url,
            success: function(result){
                $('#table').html(result);
            }
        });
    }

    if(e.target.classList.contains('currentPage')){
        let str = e.target.href;

        let iniPa = str.indexOf('ge/') + 3;
        page = str.substring(iniPa, str.length);

        let urlStarts = str.indexOf('/home');
        let url = str.substring(urlStarts, str.length) + '/' + document.getElementById('size').value;
        $.ajax({
            type: 'GET',
            url: url,
            success: function(result){
                $('#table').html(result);
            }
        });
    }
}

function searchEmployees(e){
    e.preventDefault();

    if(e.target.classList.contains('searchEmp')){
        let url = '/home/search/' + searchBtn.querySelector('input').value;
        $.ajax({
            type: 'GET',
            url: url,
            success: function(result){
                $('#table').html(result);
            }
        });
    }
    if(e.target.classList.contains('reset')){
        document.getElementById('nameSearch').value="";
        $.ajax({
            type: 'GET',
            url: '/home/page/' + page + '/' + document.getElementById('size').value,
            success: function(result){
                $('#table').html(result);
            }
        });
    }
}

function pagination(e){
    let url = '/home/page/1/' + document.getElementById('size').value;
    $.ajax({
        type: 'GET',
        url: url,
        success: function(result){
            $('#table').html(result);
        }
    });
}

function buttons(e){

    e.preventDefault();
    if(e.target.classList.contains('btnSave')){

       let str = $("#editEmpForm").serialize();
       let url = "/home/update/" + document.getElementById('empIdTxt').value;

       $.ajax({
           type:"post",
           data:str,
           url: url,
           success: function(result){
                if($(result).find('.hasError').length){
                    $('#form').html(result);
                }else{
                    $('#table').html(result);
                    document.getElementById('empIdTxt').value = "";
                    document.getElementById('empNameTxt').value = "";
                    document.getElementById('empActiveTxt').checked = false;
                    document.getElementById('dpValue').selectedIndex = -1;
                }
           }
       });
    }
    if(e.target.classList.contains('btnCancel')){
        document.getElementById('empIdTxt').value = "";
        document.getElementById('empNameTxt').value = "";
        document.getElementById('empActiveTxt').checked = false;
        document.getElementById('dpValue').selectedIndex = -1;

        let error = document.querySelector('.hasError') === null ? false : true;
        if(error) document.querySelector('.hasError').innerHTML = "";
    }
}
