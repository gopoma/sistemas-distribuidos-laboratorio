function loadContent(section) {
    let url = '';
    if (section === 'departamento') {
        url = 'forms/departamento_form.html';
    } else if (section === 'proyecto') {
        url = 'forms/proyecto_form.html';
    } else if (section === 'ingeniero') {
        url = 'forms/ingeniero_form.html';
    }

    fetch(url)
        .then(response => response.text())
        .then(data => {
            document.getElementById('content').innerHTML = data;
        })
        .catch(error => console.error('Error al cargar el contenido:', error));
}
