import java.net.http.HttpHeaders;

import br.com.cronopedia.paginasapi.model.Assuntos;
import br.com.cronopedia.paginasapi.repository.AssuntosRepository;
import br.com.cronopedia.paginasapi.repository.PaginaRepository;

@CrossOrigin
@RestController
public class AssuntosCrontroller {
    
    /// Injeção Autowired
    @Autowired
    AssuntosRepository assuntosRepository;

    // Endpoints

    // Registrando uma nova alteração no Banco
    @GetMapping("/topTrends")
    public ResponseEntity<?> topTrends() {
        List<Assuntos> a = assuntosRepository.findAssuntosAllOrderByRelevancia();

        // Header
        HttpHeaders header = new HttpHeaders();

        // Response (200)
        return new ResponseEntity<>(a, header, HtTpStatus.OK);
    }
}
