## http://korea.gnu.org/manual/release/make/make-sjp/make-ko_toc.html
.PHONY : help clean test build run pull push stop-db
.DEFAULT : xxx

PROFILE ?= local
GIT_CURRENT_BRANCH := $(shell git rev-parse --abbrev-ref HEAD)
LOCAL_MYSQL_PORT ?= 3306
LOCAL_DB_NAME ?= my-local-db
LOCAL_MYSQL_PASSWORD ?= my-local-db
LOCAL_DB_USER := $(LOCAL_DB_NAME)
LOCAL_DB_CONTAINER := $(LOCAL_DB_NAME)
RUNNING_DB_CONTAINER := $(shell docker ps -f name=$(LOCAL_DB_CONTAINER) --format "{{.Names}}")

## https://gist.github.com/prwhite/8168133#gistcomment-3785627
help: ## show help message
	@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m\033[0m\n"} /^[$$()% 0-9a-zA-Z_-]+:.*?##/ { printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)

stop-mysql: ## Stop DB Docker Container
ifeq ($(RUNNING_DB_CONTAINER),$(LOCAL_DB_CONTAINER))
	docker stop $(LOCAL_DB_CONTAINER)
else
	@echo "DB($(LOCAL_DB_CONTAINER)) is not running"
endif

start-mysql: ## Start DB Docker Container
ifneq ($(RUNNING_DB_CONTAINER),$(LOCAL_DB_CONTAINER))
	@docker run --name $(LOCAL_DB_CONTAINER) -d \
	-v ${PWD}/docker/schema:/docker-entrypoint-initdb.d \
	-v ${PWD}/docker/mysql-character-config.cnf:/etc/mysql/conf.d/my.cnf \
	-p $(LOCAL_MYSQL_PORT):3306 \
	-e MYSQL_DATABASE="$(LOCAL_DB_NAME)"  \
	-e MYSQL_USER="$(LOCAL_DB_USER)" \
	-e MYSQL_PASSWORD="$(LOCAL_MYSQL_PASSWORD)" \
	-e MYSQL_ALLOW_EMPTY_PASSWORD="true" \
	mysql
else
	@echo "DB($(LOCAL_DB_CONTAINER)) is Already running."
endif
