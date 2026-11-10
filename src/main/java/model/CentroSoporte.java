package model;

public class CentroSoporte {
    private Cola<Solicitud> solicitudesPendientes;

    public CentroSoporte(){
        this.solicitudesPendientes= new Cola<>();
    }

    public void addSolicitud(Solicitud solicitud){
        solicitudesPendientes.encolar(solicitud);
    }

    public void desencolarSolicitud(){
        solicitudesPendientes.desenconlar();
    }

    //retornar una nueva cola con las solicitudes seleccionadas y retirar esas solicitudes de la cola de pendientes
    //Primero se consideran las solicitudes de prioridad alta en su orden de llegada. Después se
    //consideran las de prioridad normal
    public Cola<Solicitud> seleccionarSolicitudes(int minutosDisponibles){
        if(solicitudesPendientes.isEmpty() || minutosDisponibles<=0){
            return new Cola<>();
        }
        Solicitud aux= null;
        Cola<Solicitud> colaAux1= solicitudesPendientes.cloneRecursivo();
        Cola<Solicitud> colaAux0= solicitudesPendientes.cloneRecursivo();
        Cola<Solicitud> colaSeleccionados= new Cola<>();
        while(colaAux1.getSize()!= 0){
            aux= colaAux1.desenconlar();
            if(aux.getPrioridad()== true && aux.getDuracionEstimada()<= minutosDisponibles){
                colaSeleccionados.encolar(aux);
                minutosDisponibles= minutosDisponibles-aux.getDuracionEstimada();
            }
        }while(colaAux0.getSize()!= 0){
            aux= colaAux0.desenconlar();
            if(aux.getPrioridad()== false && aux.getDuracionEstimada()<= minutosDisponibles){
                colaSeleccionados.encolar(aux);
                minutosDisponibles= minutosDisponibles-aux.getDuracionEstimada();
            }
        }Cola<Solicitud> colaSeleccionadosAux= colaSeleccionados.cloneRecursivo();
        while(colaSeleccionadosAux.getSize()!= 0){
            aux= colaSeleccionadosAux.desenconlar();
            solicitudesPendientes.desencolarElementoEspecifico(aux);
        }
        return colaSeleccionados;
    }

}
