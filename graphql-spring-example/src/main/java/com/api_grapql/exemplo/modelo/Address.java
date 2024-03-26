package com.api_grapql.exemplo.modelo;

public record Address(
  int Casa_id,
  int userId,
  int numero_casa,
  String rua,
  String cidade,
  String CEP,
  String pais
) {
    public Address() {
        this(0,0,0,"","","","");
    }
}