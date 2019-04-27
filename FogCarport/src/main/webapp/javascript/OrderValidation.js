/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.addEventListener("DOMContentLoaded", fillDropdownsDimensions);

function fillDropdownsDimensions() { 
    let lengthOption = document.getElementById('input-length');  
    let widthOption = document.getElementById('input-width'); 
    for (let i = 240; i < 750; i = i+30) { 
        lengthOption.innerHTML += '<option value="'+i+'">'+i+' cm</option>';
        widthOption.innerHTML += '<option value="'+i+'">'+i+' cm</option>';
    }
};

let inputlength = document.getElementById("input-length");
let inputwidth = document.getElementById("input-width");
let submit = document.getElementById("submit-btn");

inputlength.addEventListener("change",function(){ValidateCarportInput();});
inputwidth.addEventListener("change",function(){ValidateCarportInput();});

function ValidateCarportInput(){
        
    let inputLengthValue = inputlength.options[inputlength.selectedIndex].value;
    let inputWidthValue = inputwidth.options[inputwidth.selectedIndex].value;
    
    if(inputLengthValue !== "" && inputWidthValue !== ""){
        submit.classList.remove("disabled");
        submit.removeAttribute("disabled");
    }
    
    else{
        submit.classList.add("disabled");
        submit.setAttribute("disabled", "disabled");
    }
}

