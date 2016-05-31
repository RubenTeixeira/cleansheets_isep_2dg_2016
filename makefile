all:
	@make build
	@make run
build:
	@./scripts/build.sh

run:
	@./scripts/run.sh

console:
	@./scripts/console.sh
