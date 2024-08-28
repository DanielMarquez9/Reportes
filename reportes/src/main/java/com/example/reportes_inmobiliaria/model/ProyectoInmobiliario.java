@Entity
public class ProyectoInmobiliario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ubicacion;
    private Double precio;
    // getters y setters
}
