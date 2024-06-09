prod-build:
	docker compose -f docker-compose.yaml build
prod:
	make prod-build && docker compose -f docker-compose.yaml up
down:
	docker compose down