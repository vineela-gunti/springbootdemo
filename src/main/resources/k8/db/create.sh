#/bin/bash
kubectl create -f postgres-configmap.yaml
kubectl create -f postgres-pv.yaml
kubectl create -f postgres-pvc.yaml
kubectl create -f postgres-deployment.yaml
kubectl create -f postgres-service.yaml
