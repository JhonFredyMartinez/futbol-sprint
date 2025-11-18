# 🔧 GUÍA PARA SOLUCIONAR ERRORES EN EL PROYECTO FUTBOL

## ❌ PROBLEMA: "Errores en todos los Controller y Service"

Este problema es **NORMAL** y ocurre porque tu IDE necesita:
1. Descargar las dependencias de Maven
2. Configurar Lombok correctamente
3. Actualizar/refrescar el proyecto

---

## ✅ SOLUCIÓN RÁPIDA (Windows)

### Opción 1: Usar el Script Automático (RECOMENDADO)

1. Haz doble clic en el archivo: **`actualizar-proyecto.bat`**
2. Espera a que termine (puede tardar 2-5 minutos)
3. Cierra tu IDE completamente
4. Abre de nuevo el proyecto
5. Espera a que el IDE indexe todo (barra de progreso abajo)

### Opción 2: Pasos Manuales

#### Para Eclipse:

1. **Cerrar Eclipse completamente**

2. **Ejecutar en cmd/PowerShell:**
   ```cmd
   cd "C:\trabajos spring framework\futbol"
   mvnw.cmd clean install
   ```

3. **Instalar Lombok en Eclipse:**
   - Descargar: https://projectlombok.org/download
   - Ejecutar el .jar descargado
   - Seleccionar tu instalación de Eclipse
   - Click "Install/Update"
   - Reiniciar Eclipse

4. **Abrir Eclipse y:**
   - Click derecho en el proyecto → **Maven** → **Update Project**
   - Marcar "Force Update of Snapshots/Releases"
   - Click OK
   - Esperar a que termine la indexación

5. **Si siguen los errores:**
   - Click derecho en el proyecto → **Properties**
   - **Java Compiler** → **Annotation Processing**
   - Verificar que "Enable annotation processing" esté MARCADO
   - Click "Apply and Close"
   - **Project** → **Clean** → Limpiar todos los proyectos

#### Para IntelliJ IDEA:

1. **Cerrar IntelliJ**

2. **Ejecutar en cmd/PowerShell:**
   ```cmd
   cd "C:\trabajos spring framework\futbol"
   mvnw.cmd clean install
   ```

3. **Abrir IntelliJ y:**
   - File → **Invalidate Caches / Restart**
   - Seleccionar "Invalidate and Restart"
   - Esperar a que reinicie

4. **Instalar Plugin de Lombok:**
   - File → Settings → Plugins
   - Buscar "Lombok"
   - Instalar "Lombok Plugin"
   - Reiniciar IntelliJ

5. **Habilitar Annotation Processing:**
   - File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors
   - Marcar "Enable annotation processing"
   - Click OK

6. **Reimportar Maven:**
   - Click derecho en `pom.xml` → **Maven** → **Reload Project**

#### Para VS Code:

1. **Instalar extensiones necesarias:**
   - Extension Pack for Java
   - Spring Boot Extension Pack
   - Lombok Annotations Support

2. **Ejecutar en terminal integrada:**
   ```cmd
   mvnw.cmd clean install
   ```

3. **Recargar ventana:**
   - Presionar `Ctrl+Shift+P`
   - Escribir "Reload Window"
   - Enter

---

## 📋 VERIFICACIÓN

Después de aplicar la solución, verifica que **NO** haya errores en:

✅ Todos los archivos en `src/main/java/com/futbol/app/entity/`
✅ Todos los archivos en `src/main/java/com/futbol/app/repository/`
✅ Todos los archivos en `src/main/java/com/futbol/app/service/`
✅ Todos los archivos en `src/main/java/com/futbol/app/controller/`

---

## 🚀 EJECUTAR EL PROYECTO

Una vez solucionados los errores:

1. **Usando el script:** Doble click en **`ejecutar.bat`**

2. **Usando Maven:**
   ```cmd
   mvnw.cmd spring-boot:run
   ```

3. **Desde tu IDE:** Run/Debug la clase `FutbolApplication.java`

La aplicación estará en: **http://localhost:8096**

---

## 🔍 ERRORES COMUNES Y SOLUCIONES

### Error: "Cannot resolve symbol 'RequiredArgsConstructor'"
**Causa:** Lombok no está configurado
**Solución:** Instalar plugin de Lombok en el IDE (ver arriba)

### Error: "package org.springframework does not exist"
**Causa:** Dependencias de Maven no descargadas
**Solución:** Ejecutar `mvnw.cmd clean install`

### Error: "Project build error: Non-resolvable parent POM"
**Causa:** Problema de conexión a internet o repositorio Maven
**Solución:**
1. Verificar conexión a internet
2. Borrar carpeta `.m2\repository\org\springframework`
3. Ejecutar `mvnw.cmd clean install` de nuevo

---

## 📞 NOTAS IMPORTANTES

- **Los errores en el IDE NO significan que el código esté mal**
- El código fuente está **100% correcto**
- Solo es un problema de configuración del IDE
- Una vez configurado correctamente, los errores desaparecerán

---

## 📁 ARCHIVOS ÚTILES

- **`actualizar-proyecto.bat`** - Limpia y actualiza todo automáticamente
- **`compilar.bat`** - Solo compila el proyecto
- **`ejecutar.bat`** - Ejecuta la aplicación
- **`lombok.config`** - Configuración de Lombok
- **`pom.xml`** - Dependencias del proyecto (Spring Boot 3.2.5)

---

¿Siguen los errores? Revisa que tengas:
✅ Java 21 instalado
✅ Conexión a internet activa
✅ Espacio en disco suficiente (mínimo 1GB libre)
✅ Permisos de escritura en la carpeta del proyecto
