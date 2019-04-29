/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let carportLength = document.getElementById("carport-length").value;
let carportWidth = document.getElementById("carport-width").value;

let shedLength = createShedDimensions(carportLength);
let shedWidth = createShedDimensions(carportWidth);

function createShedDimensions(e){
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

let lengthOptions = document.getElementById("shed-length");
let widthOptions = document.getElementById("shed-width");
fillDropDownShedDimensions();

function fillDropDownShedDimensions() {
    for (i in shedLength) {
        lengthOptions.options[lengthOptions.options.length] = new Option(shedLength[i], i);
    }
    for (j in shedWidth) {
        widthOptions.options[widthOptions.options.length] = new Option(shedWidth[j], j);
    }
}
