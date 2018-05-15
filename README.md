# centroDeLlamadas
En este proyecto se encuentran basicamente e clases qu administran el callCenter WorkerThread,CallCenter y Dispatcher
En la WorkerThread se define la funcion de cada hilo (operador) con una llamada.
En la clase Dispatcher se gestiona llamada asignandoles el operador para que la conteste y modificacondo propiedades tanto de
la llamada como de el operador (por ejemplo el operador tiene un estado de "disponible" o "Ocupado"). En caso de que no 
existan operadores diponibles en ese instante la llamada queda en estado "encolada" y se almacena en una lista.
En la clase CallCenter se definen 2 metodos principales para el funcionamiento del callcenter que son recibirLlamadasConcurrentes
y procesarEncoladas
Que por su descripción gestionan llamadas concurrentes las cuales al no poder contestadas por falta de operadores quedan encoladas
para que posteriormente se procesen (queden en estado "contestada").


Requerimientos
Debe existir una clase Dispatcher encargada de manejar las llamadas, y debe contener el método dispatchCall para que las
asigne a los empleados disponibles.(Alcanzado)
El método dispatchCall puede invocarse por varios hilos al mismo tiempo.(Alcanzado)
La clase Dispatcher debe tener la capacidad de poder procesar 10 llamadas al mismo tiempo (de modo concurrente).(Alcanzado)
Cada llamada puede durar un tiempo aleatorio entre 5 y 10 segundos. (Alcanzado)
Debe tener un test unitario donde lleguen 10 llamadas. (Alcanzado)

Extras/Plus
Dar alguna solución sobre qué pasa con una llamada cuando no hay ningún empleado libre.(Alcanzado)
Dar alguna solución sobre qué pasa con una llamada cuando entran más de 10 llamadas concurrentes.(Alcanzado)
Agregar los tests unitarios que se crean convenientes.(Alcanzado)
Agregar documentación de código(Alcanzado)
