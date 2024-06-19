function loadProyectos() {
    fetch('http://localhost:8080/proyecto')
        .then(response => response.json())
        .then(data => {
            const content = document.getElementById('projects-list');
            content.innerHTML = '<h2>Proyectos</h2><ul>' + data.map(proj => `
                <li>ID: ${proj.idProyecto}, Nombre: ${proj.Nombre}, Fecha de Inicio: ${proj.fecInicio}, Fecha Final: ${proj.fecFinal}, ID Departamento: ${proj.idDepartamentos.id}</li>
            `).join('') + '</ul>';
        })
        .catch(error => console.error('Error:', error));
}

function loadProyectosByDepartamento() {
    const departmentId = document.getElementById('department-id').value;
    if (!departmentId) {
        alert('Por favor, ingrese un ID de departamento');
        return;
    }

    fetch(`http://localhost:8080/proyecto/${departmentId}/departamento`)
        .then(response => response.json())
        .then(data => {
            const content = document.getElementById('department-projects-list');
            content.innerHTML = '<h2>Proyectos por Departamento</h2><ul>' + data.map(item => `
                <li>ID Proyecto: ${item.proyecto.idProyecto}, Nombre Proyecto: ${item.proyecto.Nombre}, Fecha de Inicio: ${item.proyecto.fecInicio}, Fecha Final: ${item.proyecto.fecFinal}, 
                ID Departamento: ${item.proyecto.idDepartamentos.id}, Nombre Departamento: ${item.departamento.nombre}, Teléfono Departamento: ${item.departamento.Telefono}, Fax Departamento: ${item.departamento.Fax}</li>
            `).join('') + '</ul>';
        })
        .catch(error => console.error('Error:', error));
}

function loadProyectoById() {
    const projectId = document.getElementById('project-id').value;
    if (!projectId) {
        alert('Por favor, ingrese un ID de proyecto');
        return;
    }

    fetch(`http://localhost:8080/proyecto/${projectId}`)
        .then(response => response.json())
        .then(data => {
            const content = document.getElementById('project-details');
            content.innerHTML = `
                <h2>Detalles del Proyecto</h2>
                <p>ID: ${data.idProyecto}</p>
                <p>Nombre: ${data.Nombre}</p>
                <p>Fecha de Inicio: ${data.fecInicio}</p>
                <p>Fecha Final: ${data.fecFinal}</p>
                <p>ID Departamento: ${data.idDepartamentos.id}</p>
            `;
        })
        .catch(error => console.error('Error:', error));
}

function createProyecto() {
    const nombre = document.getElementById('nombre').value;
    const fecInicio = document.getElementById('fecInicio').value;
    const fecFinal = document.getElementById('fecFinal').value;
    const idDepartamentos = document.getElementById('idDepartamentos').value;

    if (!nombre || !fecInicio || !fecFinal || !idDepartamentos) {
        alert('Por favor, complete todos los campos del formulario');
        return;
    }

    const proyecto = {
        Nombre: nombre,
        Fec_Inicio: fecInicio,
        Fec_Final: fecFinal,
        idDepartamentos: parseInt(idDepartamentos)
    };

    fetch('http://localhost:8080/proyecto', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(proyecto)
    })
    .then(response => response.json())
    .then(data => {
        alert('Proyecto registrado exitosamente');
        loadProyectos();
    })
    .catch(error => console.error('Error:', error));
}

function updateProyecto() {
    const id = prompt('Ingrese el ID del proyecto a actualizar:');
    if (!id) {
        alert('Por favor, ingrese un ID de proyecto para actualizar');
        return;
    }

    const nombre = document.getElementById('nombre').value;
    const fecInicio = document.getElementById('fecInicio').value;
    const fecFinal = document.getElementById('fecFinal').value;
    const idDepartamentos = document.getElementById('idDepartamentos').value;

    if (!nombre || !fecInicio || !fecFinal || !idDepartamentos) {
        alert('Por favor, complete todos los campos del formulario');
        return;
    }

    const proyecto = {
        idProyecto: parseInt(id),
        Nombre: nombre,
        Fec_Inicio: fecInicio,
        Fec_Final: fecFinal,
        idDepartamentos: parseInt(idDepartamentos)
    };

    fetch('http://localhost:8080/proyecto', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(proyecto)
    })
    .then(response => response.json())
    .then(data => {
        alert('Proyecto actualizado exitosamente');
        loadProyectos();
    })
    .catch(error => console.error('Error:', error));
}

function deleteProyecto() {
    const id = document.getElementById('delete-id').value;
    if (!id) {
        alert('Por favor, ingrese un ID de proyecto para eliminar');
        return;
    }

    fetch(`http://localhost:8080/proyecto/${id}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            alert('Proyecto eliminado exitosamente');
            loadProyectos();
        } else {
            alert('Error al eliminar el proyecto');
        }
    })
    .catch(error => console.error('Error:', error));
}
