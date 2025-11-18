# Desplegar en Render - Proyecto Futbol

## ✅ Archivos Preparados

- ✅ **Dockerfile** - Multi-stage build (compila automáticamente en Render)
- ✅ **.dockerignore** - Optimiza el build de Docker
- ✅ **Sin Lombok** - Compatible con cualquier versión de Java

## 📋 Pasos para Desplegar en Render

### 1. Subir Proyecto a GitHub

```bash
# Inicializar repositorio (si no existe)
git init

# Agregar archivos
git add .

# Crear commit
git commit -m "Proyecto Spring Boot Futbol - Listo para Render"

# Crear repositorio en GitHub y conectar
git remote add origin https://github.com/TU-USUARIO/futbol.git
git branch -M main
git push -u origin main
```

### 2. Crear Web Service en Render

1. Ve a [https://render.com](https://render.com)
2. Click en **"New +"** → **"Web Service"**
3. Conecta tu repositorio de GitHub
4. Selecciona el repositorio **futbol**

### 3. Configurar el Servicio

**Configuración Básica:**
- **Name:** `futbol-app` (o el que prefieras)
- **Region:** Oregon (US West) o el más cercano
- **Branch:** `main`
- **Runtime:** `Docker`
- **Instance Type:** Free

**Variables de Entorno (Environment Variables):**

Agrega estas variables (muy importante):

```
SPRING_DATASOURCE_URL=jdbc:mysql://bjslygwl8laqgij48zvg-mysql.services.clever-cloud.com:3306/bjslygwl8laqgij48zvg?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true

SPRING_DATASOURCE_USERNAME=uxvsyuzrmqnvjrf6

SPRING_DATASOURCE_PASSWORD=g61fjaZb7ziLs8QXdb4s

SERVER_PORT=8096
```

### 4. Configuración Avanzada (IMPORTANTE)

En **Advanced Settings**:

- **Health Check Path:** `/actuator/health`
- **Auto-Deploy:** `Yes` (despliega automáticamente con cada push a GitHub)

### 5. Desplegar

1. Click en **"Create Web Service"**
2. Render comenzará a:
   - ✅ Clonar tu repositorio
   - ✅ Ejecutar Dockerfile (etapa 1: compilar JAR con Maven)
   - ✅ Construir imagen Docker (etapa 2: imagen ligera con Java runtime)
   - ✅ Desplegar el contenedor
3. **Espera 10-15 minutos** (primera vez es más lento porque compila desde cero)

### 6. Verificar Despliegue

Una vez desplegado, Render te dará una URL como:
```
https://futbol-app.onrender.com
```

Visita la URL para ver tu aplicación funcionando con el menú principal.

## 🎯 Ventajas del Multi-Stage Build

✅ **No necesitas generar JAR localmente** - Render lo hace automáticamente

✅ **No subes JAR a GitHub** - Solo código fuente

✅ **Imagen Docker más pequeña** - Solo JRE en producción (no Maven completo)

✅ **Build reproducible** - Siempre compila desde código fuente limpio

## 🔧 Desarrollo Local

### Ejecutar aplicación localmente

```bash
ejecutar.bat
```

### Generar JAR localmente (opcional)

```bash
build-jar.bat
```

O manualmente:
```bash
mvnw.cmd clean package -DskipTests
```

### Probar Dockerfile localmente (requiere Docker Desktop)

```bash
docker build -t futbol-app .
docker run -p 8096:8096 futbol-app
```

## 📝 Notas Importantes

### Free Tier de Render

- ✅ 750 horas/mes gratis
- ⚠️ El servicio se "duerme" después de 15 min de inactividad
- ⏱️ Primera carga después de dormir toma ~30-60 segundos
- 💾 Builds: ~10-15 min (primera vez), ~5-7 min (siguientes)

### Base de Datos

- 🔗 Conectada a **Clever Cloud MySQL**
- ✅ No necesitas configurar base de datos en Render
- ⚠️ Asegúrate de que las credenciales en las variables de entorno sean correctas

### Puerto

- 🔌 La app usa puerto **8096** internamente
- 🌐 Render mapea automáticamente al puerto 443 (HTTPS)

## 🐛 Solución de Problemas

### Error: "Build failed"

1. Revisa los logs de build en Render Dashboard
2. Verifica que `pom.xml` esté correcto
3. Asegúrate de que todas las dependencias se puedan descargar

### Error: "Application error" o "Service Unavailable"

1. **Revisa los logs** en Render Dashboard → Logs
2. Verifica las **variables de entorno** (especialmente la URL de MySQL)
3. Verifica que la base de datos MySQL esté accesible desde Render
4. Comprueba que el puerto 8096 esté expuesto correctamente

### Error: "Cannot connect to database"

Posibles causas:
- ❌ Variables de entorno mal configuradas
- ❌ Clever Cloud MySQL no permite conexiones externas
- ❌ URL de conexión incorrecta

Solución:
1. Verifica las credenciales en Clever Cloud
2. Asegúrate de que la URL incluya `allowPublicKeyRetrieval=true`

### La app se "duerme" constantemente

Esto es normal en el Free Tier de Render. Opciones:
- ⬆️ Upgrade a plan pago ($7/mes)
- 🔄 Usa un servicio de "ping" como UptimeRobot para mantenerla activa
- ⏰ Acepta el delay de ~30s en la primera carga

## ✅ Checklist Final

Antes de desplegar, verifica:

- [ ] Código fuente en GitHub (rama `main`)
- [ ] `Dockerfile` con multi-stage build
- [ ] `.dockerignore` actualizado
- [ ] Variables de entorno configuradas en Render:
  - [ ] SPRING_DATASOURCE_URL
  - [ ] SPRING_DATASOURCE_USERNAME
  - [ ] SPRING_DATASOURCE_PASSWORD
  - [ ] SERVER_PORT
- [ ] Web Service creado en Render
- [ ] Runtime = Docker

## 🚀 Comandos Git Útiles

### Hacer cambios y redesplegar

```bash
# Hacer cambios en el código
# ...

# Ver cambios
git status

# Agregar cambios
git add .

# Commit
git commit -m "Descripcion de los cambios"

# Push (esto redespliega automáticamente en Render)
git push
```

### Ver logs de Git

```bash
git log --oneline
```

## 📊 Monitoreo

En Render Dashboard puedes ver:
- 📈 Métricas de uso (CPU, RAM)
- 📝 Logs en tiempo real
- 🔄 Historial de deploys
- ⚙️ Configuración

## 🎉 ¡Listo!

Tu aplicación de gestión de fútbol estará disponible en internet 24/7.

**URL de ejemplo:** https://futbol-app.onrender.com

**Características:**
- ⚽ Gestión de Asociaciones
- 🏟️ Gestión de Clubes
- 🏆 Gestión de Competiciones
- 👔 Gestión de Entrenadores
- 👤 Gestión de Jugadores
- 🎨 Interfaz moderna con Bootstrap 5
- 💾 Base de datos MySQL en Clever Cloud

---

**¿Problemas?** Revisa los logs en Render Dashboard → Logs tab.
