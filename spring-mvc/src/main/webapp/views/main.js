// navbar
const navMenu = document.getElementById('nav-menu'),
      toggleMenu = document.getElementById('nav-toggle'),
      closeMenu = document.getElementById('nav-close');

if (toggleMenu) {
    toggleMenu.addEventListener('click', () => {
        navMenu.classList.toggle('show');
    });
}

if (closeMenu) {
    closeMenu.addEventListener('click', () => {
        navMenu.classList.remove('show');
    });
}

const navLink = document.querySelectorAll('.nav__link');

function linkAction() {
    navLink.forEach(n => n.classList.remove('active'));
    this.classList.add('active');
    navMenu.classList.remove('show');
}

navLink.forEach(n => n.addEventListener('click', linkAction));

//  toggle dropdown menu and change icon
document.addEventListener("DOMContentLoaded", function () {
    const dropdownToggles = document.querySelectorAll(".dropdown-toggle");
    dropdownToggles.forEach(function (toggle) {
        toggle.addEventListener("click", function () {
            const dropdownMenu = toggle.nextElementSibling;
            dropdownMenu.classList.toggle("show");
            const icon = toggle.querySelector("i");
            icon.classList.toggle("fa-angle-down");
            icon.classList.toggle("fa-angle-up");
        });
    });
});

// faq
document.addEventListener("DOMContentLoaded", function () {
    const accordionItemHeaders = document.querySelectorAll(".accordion-item-header");

    accordionItemHeaders.forEach(accordionItemHeader => {
        accordionItemHeader.addEventListener("click", event => {
            accordionItemHeader.classList.toggle("active");
            const accordionItemBody = accordionItemHeader.nextElementSibling;
            if (accordionItemHeader.classList.contains("active")) {
                accordionItemBody.style.maxHeight = accordionItemBody.scrollHeight + "px";
            } else {
                accordionItemBody.style.maxHeight = 0;
            }
        });
    });
});





////// navbar
//const navMenu = document.getElementById('nav-menu'),
//      toggleMenu = document.getElementById('nav-toggle'),
//      closeMenu = document.getElementById('nav-close');
//
//toggleMenu.addEventListener('click', ()=>{
//    navMenu.classList.toggle('show');
//});
//
//closeMenu.addEventListener('click', ()=>{
//    navMenu.classList.remove('show');
//});
//
//const navLink = document.querySelectorAll('.nav__link');   
//
//function linkAction(){
//  navLink.forEach(n => n.classList.remove('active'));
//  this.classList.add('active');
//  navMenu.classList.remove('show');
//}
//navLink.forEach(n => n.addEventListener('click', linkAction));
//
//
//
//
////  toggle dropdown menu and change icon
//document.addEventListener("DOMContentLoaded", function () {
//  const dropdownToggles = document.querySelectorAll(".dropdown-toggle");
//  dropdownToggles.forEach(function (toggle) {
//      toggle.addEventListener("click", function () {
//          const dropdownMenu = toggle.nextElementSibling;
//          dropdownMenu.classList.toggle("show");
//          const icon = toggle.querySelector("i");
//          icon.classList.toggle("fa-angle-down");
//          icon.classList.toggle("fa-angle-up");
//      });
//  });
//});
//
//
//// faq
//const accordionItemHeaders = document.querySelectorAll(".accordion-item-header");
//
//accordionItemHeaders.forEach(accordionItemHeader => {
//  accordionItemHeader.addEventListener("click", event => {
//
//    accordionItemHeader.classList.toggle("active");
//    const accordionItemBody = accordionItemHeader.nextElementSibling;
//    if(accordionItemHeader.classList.contains("active")) {
//      accordionItemBody.style.maxHeight = accordionItemBody.scrollHeight + "px";
//    }
//    else {
//      accordionItemBody.style.maxHeight = 0;
//    }
//    
//  });
//});


// Navbar
//const navMenu = document.getElementById('nav-menu'),
//      toggleMenu = document.getElementById('nav-toggle'),
//      closeMenu = document.getElementById('nav-close');
//
//toggleMenu.addEventListener('click', () => {
//    navMenu.classList.toggle('show');
//});
//
//closeMenu.addEventListener('click', () => {
//    navMenu.classList.remove('show');
//});
//
//const navLink = document.querySelectorAll('.nav__link');
//
//function linkAction() {
//    navLink.forEach(n => n.classList.remove('active'));
//    this.classList.add('active');
//    navMenu.classList.remove('show');
//}
//navLink.forEach(n => n.addEventListener('click', linkAction));
//
//// Toggle dropdown menu and change icon
//document.addEventListener("DOMContentLoaded", function () {
//    const dropdownToggles = document.querySelectorAll(".dropdown-toggle");
//    dropdownToggles.forEach(function (toggle) {
//        toggle.addEventListener("click", function () {
//            const dropdownMenu = toggle.nextElementSibling;
//            if (dropdownMenu) {  // Ensure the next sibling exists
//                dropdownMenu.classList.toggle("show");
//                const icon = toggle.querySelector("i");
//                if (icon) {  // Ensure the icon element exists
//                    icon.classList.toggle("fa-angle-down");
//                    icon.classList.toggle("fa-angle-up");
//                }
//            }
//        });
//    });
//});
//
//// FAQ
//const accordionItemHeaders = document.querySelectorAll(".accordion-item-header");
//
//accordionItemHeaders.forEach(accordionItemHeader => {
//    accordionItemHeader.addEventListener("click", event => {
//        accordionItemHeader.classList.toggle("active");
//        const accordionItemBody = accordionItemHeader.nextElementSibling;
//        if (accordionItemBody) {  // Ensure the next sibling exists
//            if (accordionItemHeader.classList.contains("active")) {
//                accordionItemBody.style.maxHeight = accordionItemBody.scrollHeight + "px";
//            } else {
//                accordionItemBody.style.maxHeight = 0;
//            }
//        }
//    });
//});
