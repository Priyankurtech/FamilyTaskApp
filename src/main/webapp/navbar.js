function selectMenu(menuName) {
    document.getElementById('selected-menu').innerText = menuName;
}

// Event listener to close the dropdown menu if the user clicks outside of it
document.addEventListener('click', function(event) {
    var dropdown = document.querySelector('.dropdown');
    if (!dropdown.contains(event.target)) {
        var dropdownContent = document.querySelector('.dropdown-content');
        dropdownContent.style.display = 'none';
    }
});

// Toggle the dropdown menu visibility
function toggleDropdown() {
    var dropdownContent = document.querySelector('.dropdown-content');
    dropdownContent.style.display = (dropdownContent.style.display === 'block') ? 'none' : 'block';
}

// Event listener for the dropdown button
document.querySelector('.dropbtn').addEventListener('click', toggleDropdown);