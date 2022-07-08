package Ventas;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Factura {

    public static void main(String[] args) {
        facturacion();
    }

    static void facturacion()
    {
        Scanner sc = new Scanner(System.in);

        boolean facturar = true;
        double precioTotal = 0;
        DecimalFormat df = new DecimalFormat("#.00");

        StringBuilder productosyPrecio = new StringBuilder();
        System.out.println("\nSISTEMA DE FACTURACION COMERCIAL SANTA ROSA S.A.");
        System.out.println("------------------------------------------------");

        while (facturar)
        {
            double precioUnitario = 0.00;
            String producto = "";

            while (precioUnitario == 0)
            {
                System.out.print("Nombre del Producto ? : ");
                producto = sc.nextLine();
                precioUnitario = precioUnitario(producto);
            }

            System.out.print("Cantidad : ");
            int cantidad = sc.nextInt();

            double precioProducto = precioUnitario * cantidad;
            precioTotal += precioProducto;

            producto = producto.substring(0, 1).toUpperCase() + producto.substring(1);

            productosyPrecio.append(producto + "\t\t\t\t" + cantidad + "\t\t\tS/ " + df.format(precioUnitario)+ "\t\t\tS/ " + df.format(precioProducto));
            productosyPrecio.append("\n");

            System.out.print("Continuar s/n? : ");
            String respuesta = sc.next();

            facturar = respuesta.equals("s");

            sc.nextLine();
        }

        System.out.println();
        System.out.println("\n--------------------------------------------------");
        System.out.println("Comercial Santa Rosa S.A.           RUC 2034102234");
        System.out.println("--------------------------------------------------");
        System.out.println("FACTURA No. 0023445");
        System.out.println("--------------------------------------------------");
        System.out.println("PRODUCTO         CANTIDAD    P. UNITARIO       SUB-TOTAL");
        System.out.println(productosyPrecio);
        System.out.printf("Sub-Total :     S/ %.2f\n", precioTotal);
        System.out.printf("IGV :           S/ %.2f\n", precioTotal*0.18);
        System.out.println();
        System.out.printf("TOTAL A PAGAR : S/ %.2f" ,precioFinalIGV(precioTotal));

    }

    static double precioFinalIGV(double precioTotal)
    {
        final double IGV = 0.18;
        return precioTotal + (precioTotal * IGV);
    }


    static double precioUnitario(String producto)
    {
        double precio = 0.00;

        switch (producto.toLowerCase())
        {
            case "azucar" -> precio = 4.00;
            case "cafe" -> precio = 5.00;
            case "avena" -> precio = 2.50;
            case "cereales" -> precio = 6.80;
            case "gelatina" -> precio = 3.00;
            case "harina" -> precio = 3.20;
            case "sal" -> precio = 1.00;
            case "mayonesa" -> precio = 2.20;
            case "mermelada" -> precio = 1.40;
            case "miel" -> precio = 1.50;
            case "huevo" -> precio = 1.00;
            case "te" -> precio = 1.20;
            case "aceitunas" -> precio = 3.40;
            case "frijoles" -> precio = 4.60;
            case "atun" -> precio = 5.50;
            case "leche condensada" -> precio = 4.20;
            case "leche deslactosada" -> precio = 4.50;
            case "leche en polvo" -> precio = 3.30;
            case "leche evaporada" -> precio = 4.30;
            case "leche light" -> precio = 5.20;
            case "yogurt" -> precio = 5.80;
            case "mantequilla" -> precio = 1.60;
            case "queso" -> precio = 3.80;
            case "jamonada" -> precio = 3.90;
            case "chocolates" -> precio = 6.30;
            case "chocolate en polvo" -> precio = 5.80;
            case "malvaviscos" -> precio = 7.80;
            case "galletas dulces" -> precio = 2.30;
            case "galletas saladas" -> precio = 1.90;
            case "pan" -> precio = 0.10;
            case "pan dulce" -> precio = 0.30;
            case "pan molido" -> precio = 0.20;
            case "ajos" -> precio = 0.50;
            case "cebollas" -> precio = 0.70;
            case "papa" -> precio = 1.20;
            case "manzana" -> precio = 0.90;
            case "platanos" -> precio = 0.60;
            case "naranja" -> precio = 0.80;
            case "agua mineral" -> precio = 2.00;
            case "agua salada" -> precio = 1.80;
            case "agua natural" -> precio = 1.20;
            case "energizantes" -> precio = 2.30;
            case "cerveza" -> precio = 7.50;
            case "anis" -> precio = 2.30;
            case "ron" -> precio = 7.30;
            case "tequila" -> precio = 9.40;
            case "vodka" -> precio = 8.30;
            case "whiskey" -> precio = 2.30;
            case "salchicha" -> precio = 3.30;
            case "tocino" -> precio = 2.60;
            case "manteca" -> precio = 1.90;
            case "chorizo" -> precio = 3.10;
            case "alcohol" -> precio = 2.10;
            case "agua oxigenada" -> precio = 3.10;
            case "analgesicos" -> precio = 4.10;
            case "antigripales" -> precio = 3.40;
            case "preservativos" -> precio = 3.80;
            default -> System.out.println("El producto ingresado no esta registrado.\nPor favor, ingrese el producto nuevamente.");
        }

        return precio;
    }


    

}

