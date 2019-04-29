import java.rmi.*;
import java.rmi.server.*;
import java.lang.*;

public class ObjetoRemoto extends UnicastRemoteObject implements IObjetoRemoto
{
    public ObjetoRemoto() throws RemoteException
    {
         super();
    }
    
    public double Simpson(double a,double b,double n) throws RemoteException{
       double dx=(b-a)/n;
       double resultado,resFinal;
       resultado=EvaluaFuncion(a);
       for (int i=1 ;i<n ;i++) {
           if ((i%2)==0) {
               resultado=resultado+(2*EvaluaFuncion(i*dx));
           }
           else {
               resultado=resultado+(4*EvaluaFuncion(i*dx));
           }
        }
        resultado=resultado+EvaluaFuncion(b);
        
        resFinal=resultado*(dx/3);
        return resFinal;
    }

    public double EvaluaFuncion(double x) throws RemoteException{
        double res;
        res=x*x;
        return res;
    }

}  // Fin clase ObjetoRemoto
