function loadIngenieros() {
    fetch('http://localhost:8080/ingeniero')
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al cargar ingenieros');
            }
            return response.json();
        })
        .then(data => {
            const content = document.getElementById('engineers-list');
            content.innerHTML = '<h2>Ingenieros</h2><ul>' + data.map(ing => `
                <li>ID: ${ing.idIngeniero}, Especialidad: ${ing.Especialidad}, Cargo: ${ing.Cargo}, ID Proyecto: ${ing.idProyecto.id}</li>
            `).join('') + '</ul>';
        })
        .catch(error => console.error('Error:', error));
}

function loadIngenieroById() {
    const engineerId = document.getElementById('engineer-id-search').value;
    if (!engineerId) {
        alert('Por favor, ingrese un ID de ingeniero');
        return;
    }

    fetch(`http://localhost:8080/ingeniero/${engineerId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al cargar ingeniero');
            }
            return response.json();
        })
        .then(data => {
            const content = document.getElementById('engineer-details');
            content.innerHTML = `
                <h2>Detalles del Ingeniero</h2>
                <p>ID: ${data.idIngeniero}</p>
                <p>Especialidad: ${data.Especialidad}</p>
                <p>Cargo: ${data.Cargo}</p>
                <p>ID Proyecto: ${data.idProyecto.id}</p>
            `;
        })
        .catch(error => {
            const content = document.getElementById('engineer-details');
            content.innerHTML = `<p>${error.message}</p>`;
            console.error('Error:', error);
        });
}

function loadIngenierosByProyecto() {
    const projectId = document.getElementById('project-id-search').value;
    if (!projectId) {
        alert('Por favor, ingrese un ID de proyecto');
        return;
    }

    fetch(`http://localhost:8080/ingeniero/${projectId}/proyecto`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al cargar ingenieros por proyecto');
            }
            return response.json();
        })
        .then(data => {
            const content = document.getElementById('project-engineers-list');
            content.innerHTML = '<h2>Ingenieros por Proyecto</h2><ul>' + data.map(item => `
                <li>ID Ingeniero: ${item.ingeniero.idIngeniero}, Especialidad: ${item.ingeniero.Especialidad}, Cargo: ${item.ingeniero.Cargo}, ID Proyecto: ${item.ingeniero.idProyecto.id}, 
                Nombre Proyecto: ${item.proyecto.Nombre}, Fecha de Inicio: ${item.proyecto.fecInicio}, Fecha Final: ${item.proyecto.fecFinal}</li>
            `).join('') + '</ul>';
        })
        .catch(error => console.error('Error:', error));
}

function createIngeniero() {
    const especialidad = document.getElementById('especialidad').value;
    const cargo = document.getElementById('cargo').value;
    const idProyecto = document.getElementById('idProyecto').value;

    if (!especialidad || !cargo || !idProyecto) {
        alert('Por favor, complete todos los campos del formulario');
        return;
    }

    const ingeniero = {
        Especialidad: especialidad,
        Cargo: cargo,
        idProyecto: parseInt(idProyecto)
    };

    fetch('http://localhost:8080/ingeniero', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(ingeniero)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al registrar el ingeniero');
        }
        return response.json();
    })
    .then(data => {
        alert('Ingeniero registrado exitosamente');
        loadIngenieros();
    })
    .catch(error => console.error('Error:', error));
}

function updateIngeniero() {
    const id = prompt('Ingrese el ID del ingeniero a actualizar:');
    if (!id) {
        alert('Por favor, ingrese un ID de ingeniero para actualizar');
        return;
    }

    const especialidad = document.getElementById('especialidad').value;
    const cargo = document.getElementById('cargo').value;
    const idProyecto = document.getElementById('idProyecto').value;

    if (!especialidad || !cargo || !idProyecto) {
        alert('Por favor, complete todos los campos del formulario');
        return;
    }

    const ingeniero = {
        idIngeniero: parseInt(id),
        Especialidad: especialidad,
        Cargo: cargo,
        idProyecto: parseInt(idProyecto)
    };

    fetch('http://localhost:8080/ingeniero', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(ingeniero)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al actualizar el ingeniero');
        }
        return response.json();
    })
    .then(data => {
        alert('Ingeniero actualizado exitosamente');
        loadIngenieros();
    })
    .catch(error => console.error('Error:', error));
}

function deleteIngeniero() {
    const id = document.getElementById('delete-engineer-id').value;
    if (!id) {
        alert('Por favor, ingrese un ID de ingeniero para eliminar');
        return;
    }

    fetch(`http://localhost:8080/ingeniero/${id}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            alert('Ingeniero eliminado exitosamente');
            loadIngenieros();
        } else {
            alert('Error al eliminar el ingeniero');
        }
    })
    .catch(error => console.error('Error:', error));
}
