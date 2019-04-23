/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let inputheight = document.getElementById("input-height");
let inputlength = document.getElementById("input-length");
let inputwidth = document.getElementById("input-width");
let submit = document.getElementById("submit-btn");
let minHeight = 200;
let maxHeight = 300;
let minSide = 240;
let maxSide = 720;

// added listeners for inputfields and submit button
// for inputfields, function is needed to run ValidateCarportInput with parameters
inputheight.addEventListener("keyup",function(){ValidateCarportInput(minHeight, maxHeight, inputheight);});
inputlength.addEventListener("keyup",function(){ValidateCarportInput(minSide, maxSide, inputlength);});
inputwidth.addEventListener("keyup",function(){ValidateCarportInput(minSide, maxSide, inputwidth);});
submit.addEventListener("click", ValidateSubmit);

// checks if the input is between min and max values
// if not, removes hidden attripute from error-<p>-tag in the html
// and adds the bootstrap is-invalid styling
// variable valid is used later in the submit check
function ValidateCarportInput(min, max, input){
    
    let errorMsg = input.nextElementSibling;
    let valid = false;
    
    if(input.value < min){
        errorMsg.removeAttribute("hidden");
        input.classList.add("is-invalid");
        valid = false;
    }
    else if(input.value > max){
        errorMsg.removeAttribute("hidden");
        input.classList.add("is-invalid");
        valid = false;
    }
    else{
        errorMsg.setAttribute("hidden", "hidden");
        input.classList.remove("is-invalid");
        valid = true;
    }
    return valid;
}

// stops the sumbitbutton from submitting and defines the cases for each
// inputfield to be able to show errors for all of them at once. Submit is
// allowed if all three cases are true.
// If one or more is false, submit is not allowed and the relevant error
// messages are shown. If submit is pressed without all three cases being
// true an sweetalert alert is shown (super pretty!). 
function ValidateSubmit(e){
    e.preventDefault();
    let form = document.getElementById("carport-form");
    let heightValid = ValidateCarportInput(minHeight, maxHeight, inputheight);
    let lengthValid = ValidateCarportInput(minSide, maxSide, inputlength);
    let widthValid = ValidateCarportInput(minSide, maxSide, inputwidth);
    
    if(heightValid && lengthValid && widthValid){
        form.submit();
    }
    else{
    //swal is "SweetAlert". This is just a pretty version of the standard js alert (source: sweetalert.com)
     swal ("Fejl", "Felter er udfyldt forkert eller mangelfuldt", "error" );
    }        
}

// *****************************************************************************
// FOR RÚNI - OUTCOMMENT ALL OF THE ABOVE (minus the variables defined by let at 
// the top) AND INCOMMENT ALL OF THE BELOW. CHANGE THE BUTTON IN makeCarport.jsp
// to this:
// <button type="submit" class="btn btn-primary disabled" id="submit-btn" disabled style="margin-top: 5px;">Bestil Carport</button>
// 
// THIS MAKES THE BUTTON UNCLICKABLE UNTIL ALL INPUTS ARE CORRET - AND NO MORE SWEET ALERTS :´(
// *****************************************************************************

//inputheight.addEventListener("keyup",function(){ValidateCarportInput(minHeight, maxHeight, inputheight); ValidateSubmitButton(); });
//inputlength.addEventListener("keyup",function(){ValidateCarportInput(minSide, maxSide, inputlength); ValidateSubmitButton();});
//inputwidth.addEventListener("keyup",function(){ValidateCarportInput(minSide, maxSide, inputwidth); ValidateSubmitButton();});
//
//function ValidateCarportInput(min, max, input){
//    
//    let errorMsg = input.nextElementSibling;
//    let valid = false;
//    
//    if(input.value < min){
//        errorMsg.removeAttribute("hidden");
//        input.classList.add("is-invalid");
//        valid = false;
//    }
//    else if(input.value > max){
//        errorMsg.removeAttribute("hidden");
//        input.classList.add("is-invalid");
//        valid = false;
//    }
//    else{
//        errorMsg.setAttribute("hidden", "hidden");
//        input.classList.remove("is-invalid");
//        valid = true;
//    }
//    return valid;
//}
//
//
//function ValidateSubmitButton(){
//    let heightValid = ValidateCarportInput(minHeight, maxHeight, inputheight);
//    let lengthValid = ValidateCarportInput(minSide, maxSide, inputlength);
//    let widthValid = ValidateCarportInput(minSide, maxSide, inputwidth);
//    
//    if(heightValid && lengthValid && widthValid){
//        submit.classList.remove("disabled");
//        submit.removeAttribute("disabled");
//    }
//    else{
//        submit.classList.add("disabled");
//        submit.setAttribute("disabled", "disabled");
//    }
//}

