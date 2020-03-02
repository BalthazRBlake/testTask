const empList = document.getElementById('empList');
const formBtn = document.getElementById('formBtn');
const searchBtn = document.getElementById('searchName');
const pageSize = document.getElementById('size');

loadEventListeners();

function loadEventListeners(){
    document.addEventListener('DOMContentLoaded', loadTable);
    empList.addEventListener('click', showDetails);
    searchBtn.addEventListener('click', searchEmployees);
    formBtn.addEventListener('click', buttons);
    pageSize.addEventListener('change', pagination);
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
        /*$('#empDetails').load(url);*/
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
        //$('#form').load(url);
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
        //$('#table').load(url);
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
        let urlStarts = str.indexOf('/home');
        let url = str.substring(urlStarts, str.length) + '/' + document.getElementById('size').value;
        //$('#table').load(url);
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
        //$('#table').load(url);
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
        //$('#table').load("/home/page/1/10");
        $.ajax({
            type: 'GET',
            url: '/home/page/1/10',
            success: function(result){
                $('#table').html(result);
            }
        });
    }
}

function pagination(e){
    let url = '/home/page/1/' + document.getElementById('size').value;
    //$('#table').load(url);
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
       var str = $("#editEmpForm").serialize();

       $.ajax({
           type:"post",
           data:str,
           url:"/home/update",
           success: function(result){
            $('#table').html(result);
            document.getElementById('empIdTxt').value = "";
            document.getElementById('empNameTxt').value = "";
            document.getElementById('empActiveTxt').checked = false;
            document.getElementById('dpValue').selectedIndex = -1;
           },
           error: function(result){

           }
       });
    }
    if(e.target.classList.contains('btnCancel')){
        document.getElementById('empIdTxt').value = "";
        document.getElementById('empNameTxt').value = "";
        document.getElementById('empActiveTxt').checked = false;
        document.getElementById('dpValue').selectedIndex = -1;
    }
}
