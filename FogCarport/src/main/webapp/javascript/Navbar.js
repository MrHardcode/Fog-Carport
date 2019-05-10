/* 
 *  Malte Hviid-Magnussen
 */

$(document).ready(function () { // Makes sure that the page is loaded first.
    $(function () {
        setNavBar();
    });
});

function setNavBar() {

    let url = window.location.href; // save the url

    $('.navbar-nav li').each(function(){ // Loop through the li's
        
        let href = $(this).find('a').attr('href'); // Save the href from the a
        
        if (url === href){ // if href in link equals current url
            
            $(this).addClass('active'); // Add active Class
            
        }
    });

};

