package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.dto.EpisodioDTO;
import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.service.SerieService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieService serieService;

    @GetMapping
    public ResponseEntity<List<SerieDTO>> obterSeries() {
        return ResponseEntity.ok(serieService.obterTodasAsSeries());
    }

    @GetMapping("/top5")
    public ResponseEntity<List<SerieDTO>> obterTop5Series() {
        return ResponseEntity.ok(serieService.obterTop5Series());
    }

    @GetMapping("/lancamentos")
    public ResponseEntity<List<SerieDTO>> obterLancamentos() {
        return ResponseEntity.ok(serieService.obterLancamentos());
    }

    @GetMapping("/categoria/{nomeGenero}")
    public ResponseEntity<List<SerieDTO>> obterSeriesPorCategoria(@PathVariable String nomeGenero) {
        return ResponseEntity.ok(serieService.obterSeriesPorCategoria(nomeGenero));
    }


    @GetMapping("/{id}/temporadas/todas")
    public ResponseEntity<List<EpisodioDTO>> obterTodasTemporadas(@PathVariable Long id) {
        return ResponseEntity.ok(serieService.obterTodasTemporadas(id));
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public ResponseEntity<List<EpisodioDTO>> obterTemporadasPornumero(@PathVariable Long id, @PathVariable Integer numero) {
        return ResponseEntity.ok(serieService.obterTemporadasPornumero(id, numero));
    }


    @GetMapping("/{id}")
    public ResponseEntity<SerieDTO> obterSeriePorId(@PathVariable Long id) {
        return ResponseEntity.ok(serieService.obterPorId(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Serie> criarNovaSerie(@RequestBody @Validated Serie dados){

        return ResponseEntity.ok(serieService.criarNovaSerie(dados));
    }
}
