#!/usr/bin/env bash
set -euo pipefail

BASE_URL="${BASE_URL:-http://localhost:8081}"
AUTH="${AUTH:-orfis:orfis123}"

echo "Health"
curl -i "${BASE_URL}/actuator/health"
echo
echo

echo "Criar evento"
curl -i -u "${AUTH}" \
  -H "Content-Type: application/json" \
  -d '{
    "idPaciente": "1",
    "tipoEvento": "INICIO",
    "tipoUnidade": "UBS",
    "identificadorUnidade": "UBS-001",
    "dataHoraEvento": "30/01/2026 14:35:00",
    "detalhes": "Atendimento iniciado"
  }' \
  "${BASE_URL}/api/v1/eventos"
echo
echo

echo "Linha do tempo"
curl -i -u "${AUTH}" "${BASE_URL}/api/v1/pacientes/1/linha-do-tempo"
echo
echo

echo "Status atual"
curl -i -u "${AUTH}" "${BASE_URL}/api/v1/pacientes/1/status-atual"
echo
