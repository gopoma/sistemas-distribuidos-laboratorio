function loadDepartamentos() {
    fetch('http://localhost:8080/departamento')
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al cargar departamentos');
            }
            return response.json();
        })
        .then(data => {
            const content = document.getElementById('departments-list');
            content.innerHTML = '<h2>Departamentos</h2><ul>' + data.map(dep => `
                <li>ID: ${dep.idDepartamentos}, Nombre: ${dep.nombre}, Teléfono: ${dep.Telefono}, Fax: ${dep.Fax}</li>
            `).join('') + '</ul>';
        })
        .catch(error => console.error('Error:', error));
}

function loadDepartamentoById() {
    const departmentId = document.getElementById('department-id-search').value;
    if (!departmentId) {
        alert('Por favor, ingrese un ID de departamento');
        return;
    }

    fetch(`http://localhost:8080/departamento/${departmentId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al cargar departamento');
            }
            return response.json();
        })
        .then(data => {
            const content = document.getElementById('department-details');
            content.innerHTML = `
                <h2>Detalles del Departamento</h2>
                <p>ID: ${data.idDepartamentos}</p>
                <p>Nombre: ${data.nombre}</p>
                <p>Teléfono: ${data.Telefono}</p>
                <p>Fax: ${data.Fax}</p>
            `;
        })
        .catch(error => {
            const content = document.getElementById('department-details');
            content.innerHTML = `<p>${error.message}</p>`;
            console.error('Error:', error);
        });
}

function createDepartamento() {
    const nombre = document.getElementById('nombre').value;
    const telefono = document.getElementById('telefono').value;
    const fax = document.getElementById('fax').value;

    if (!nombre || !telefono || !fax) {
        alert('Por favor, complete todos los campos del formulario');
        return;
    }

    const departamento = {
        nombre: nombre,
        Telefono: telefono,
        Fax: fax
    };

    fetch('http://localhost:8080/departamento', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(departamento)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al registrar el departamento');
        }
        return response.json();
    })
    .then(data => {
        alert('Departamento registrado exitosamente');
        loadDepartamentos();
    })
    .catch(error => console.error('Error:', error));
}

function updateDepartamento() {
    const id = prompt('Ingrese el ID del departamento a actualizar:');
    if (!id) {
        alert('Por favor, ingrese un ID de departamento para actualizar');
        return;
    }

    const nombre = document.getElementById('nombre').value;
    const telefono = document.getElementById('telefono').value;
    const fax = document.getElementById('fax').value;

    if (!nombre || !telefono || !fax) {
        alert('Por favor, complete todos los campos del formulario');
        return;
    }

    const departamento = {
        idDepartamentos: parseInt(id),
        nombre: nombre,
        Telefono: telefono,
        Fax: fax
    };

    fetch('http://localhost:8080/departamento', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(departamento)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al actualizar el departamento');
        }
        return response.json();
    })
    .then(data => {
        alert('Departamento actualizado exitosamente');
        loadDepartamentos();
    })
    .catch(error => console.error('Error:', error));
}

function deleteDepartamento() {
    const id = document.getElementById('delete-id').value;
    if (!id) {
        alert('Por favor, ingrese un ID de departamento para eliminar');
        return;
    }

    fetch(`http://localhost:8080/departamento/${id}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            alert('Departamento eliminado exitosamente');
            loadDepartamentos();
        } else {
            alert('Error al eliminar el departamento');
        }
    })
    .catch(error => console.error('Error:', error));
}
