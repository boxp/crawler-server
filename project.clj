(defproject
  crawler-server
  "0.1.0-SNAPSHOT"
  :repl-options
  {:init-ns crawler-server.repl}
  :dependencies
  [[ring-server "0.3.1"]
   [noir-exception "0.2.2"]
   [environ "0.5.0"]
   [com.taoensso/timbre "3.2.1"]
   [markdown-clj "0.9.47"]
   [im.chit/cronj "1.0.1"]
   [org.clojure/clojure "1.6.0"]
   [com.taoensso/tower "2.0.2"]
   [log4j
    "1.2.17"
    :exclusions
    [javax.mail/mail
     javax.jms/jms
     com.sun.jdmk/jmxtools
     com.sun.jmx/jmxri]]
   [korma "0.3.3"]
   [lib-noir "0.8.4"]
   [selmer "0.6.9"]
   [com.h2database/h2 "1.4.180"]]
  :ring
  {:handler crawler-server.handler/app,
   :init crawler-server.handler/init,
   :destroy crawler-server.handler/destroy}
  :profiles
  {:uberjar {:aot :all},
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}},
   :dev
   {:dependencies
    [[ring-mock "0.1.5"]
     [ring/ring-devel "1.3.0"]
     [pjstadig/humane-test-output "0.6.0"]],
    :injections
    [(require 'pjstadig.humane-test-output)
     (pjstadig.humane-test-output/activate!)],
    :env {:dev true}}}
  :url
  "http://example.com/FIXME"
  :jvm-opts
  ["-server"]
  :plugins
  [[lein-ring "0.8.10"] [lein-environ "0.5.0"]]
  :description
  "FIXME: write description"
  :min-lein-version "2.0.0")