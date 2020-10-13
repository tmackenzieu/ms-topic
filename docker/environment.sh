#! /bin/bash

set -o errexit   # abort on nonzero exitstatus
set -o nounset   # abort on unbound variable
set -o pipefail  # don't hide errors within pipes

__dir="/app"
__file="${__dir}/$(basename "${BASH_SOURCE[0]}")"
__base="$(basename ${__file}.sh)"
cd $__dir

if [ ! -z "${SRVA_AUTH}" ];
then
  echo $SRVA_AUTH | base64 -d >> auth.json
fi
