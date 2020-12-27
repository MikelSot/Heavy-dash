const sidebarToggle = document.getElementById("sidebarToggle");
const contentWrapper = document.getElementById("content-wrapper");

sidebarToggle.addEventListener("click", () => {
    contentWrapper.classList.toggle("menu-expanded");
    contentWrapper.classList.toggle("menu-collapsed");
});