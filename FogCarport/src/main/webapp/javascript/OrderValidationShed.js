/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


let len = document.getElementById("input-length").selected;
let wid = document.getElementById("input-width").selected;

document.getElementById("check-skur").addEventListener("click", checkShedMenuVisibility);

function checkShedMenuVisibility() {
    let x = document.getElementById("check-skur").checked;
    if (x)
    {
        let div = document.getElementById("carport-shed-form");
        div.removeAttribute("hidden");
        prepareShedMenu();
    } 
    else
    {
        let div = document.getElementById("carport-shed-form");
        div.setAttribute("hidden", "hidden");
        clearShedMenu();
    }
}

//inputlength.addEventListener("change",function(){checkShedMenuVisibility();});
//inputwidth.addEventListener("change",function(){checkShedMenuVisibility();});

let lengthOptions = document.getElementById("shed-length");
let widthOptions = document.getElementById("shed-width");

function prepareShedMenu() {

    let carportLength = document.getElementById("input-length").value;
    let carportWidth = document.getElementById("input-width").value;

    let shedLength = createShedDimensions(carportLength);
    let shedWidth = createShedDimensions(carportWidth);

    function createShedDimensions(e) {
        let sValues = [];
        i = 1;
        while (true) {
            sValues[i] = e - 30 * ([i]);
            if (sValues[i] <= 100)
            {
                break;
            }
            i++;
        }
        return sValues;
    }

    fillDropDownShedDimensions();

    function fillDropDownShedDimensions() {
        for (i in shedLength) {
            lengthOptions.options[lengthOptions.options.length] = new Option(shedLength[i], i);
        }
        for (j in shedWidth) {
            widthOptions.options[widthOptions.options.length] = new Option(shedWidth[j], j);
        }
    }
}

function clearShedMenu() {
    let length = lengthOptions.options.length;
    for (k = 0; k < length; k++) {
        lengthOptions.remove(1);
    }
    let width = widthOptions.options.length;
    for (u = 0; u < width; u++) {
        widthOptions.remove(1);
    }
}