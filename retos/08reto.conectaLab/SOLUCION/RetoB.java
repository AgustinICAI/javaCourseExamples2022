class RetoB
{
    static double calculoPIMontecarlo(long iteraciones){
        double x;
        double y;
        int exito = 0;
        for (int i=0;i<iteraciones;i++)
        {
            x = Math.random();
            y = Math.random();
            if ((Math.pow(x, 2) + Math.pow(y, 2)) <= 1)
                exito++;
        }
        return (double) (4*exito)/iteraciones;
    }
    static void calcularSalida(){
        for(long iteraciones=1; iteraciones<Math.pow(10,8);iteraciones*=10){
            long start = System.nanoTime();
            double calculoPi = calculoPIMontecarlo(iteraciones);
            long end = System.nanoTime();
            double error = Math.abs(calculoPi-Math.PI)*1000*1000;
            long tiempoTotal = (end - start)/(1000*1000);//Pasar a mili segundos
            System.out.println(calculoPi+", "+iteraciones+", "+ tiempoTotal + " ms., "+(int)error+" error");
        }
    }
}
